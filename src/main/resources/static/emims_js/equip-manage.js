layui.config({
    base: '/emims/emims_module/'
    , version: '1.0'
});
layui.use(['element', 'form', 'table', 'laydate', 'layer','layarea','laytpl','tree'], function () {
    var element = layui.element;
    var form = layui.form;
    var table = layui.table;
    var laydate = layui.laydate;
    var layer = layui.layer;
    var layarea=layui.layarea;
    var laytpl=layui.laytpl;
    var tree=layui.tree;
    var $=layui.jquery;
    form.render();
    element.init();

    var currentDeviceLocation;
    var cols =
        [
            [
                {checkbox: true},
                {field: 'deviceMac', title: '设备号'},
                {field: 'deviceInfo', title: '设备信息'},
                {field: 'code', title: '设备编码'},
                {field: 'location', title: '区域'},
            ]
        ];
    var dataTableOptions = {
        elem: '#deviceTable',
        url: '/emims/api/monitorDevice',
        method: 'get',
        request: {
            pageName: 'page',
            limitName: 'size',
        },
        where: {
            start: '',
            end: '',
            searchText: ''
        },
        response: {
            statusName: 'status', //规定数据状态的字段名称，默认：code
            statusCode: 200, //规定成功的状态码，默认：0
            msgName: 'message', //规定状态信息的字段名称，默认：msg
            countName: 'totalCount', //规定数据总数的字段名称，默认：count
            dataName: 'data' //规定数据列表的字段名称，默认：data
        },
        // contentType: 'application/json',
        // height: 350,
        page: true,
        limit: 15,
        loading: true,
        cols: cols,
        even: true,
        size: 'sm',
        done: function (res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            console.log(res);

            //得到当前页码
            console.log(curr);
            //得到数据总量
        },
        text: {
            none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
        }
    }

    var data1 = [{
        title: '江西'
        ,id: 1
        ,children: [{
            title: '南昌'
            ,id: 1000
            ,children: [{
                title: '青山湖区'
                ,id: 10001
            },{
                title: '高新区'
                ,id: 10002
            }]
        },{
            title: '九江'
            ,id: 1001
        },{
            title: '赣州'
            ,id: 1002
        }]
    },{
        title: '广西'
        ,id: 2
        ,children: [{
            title: '南宁'
            ,id: 2000
        },{
            title: '桂林'
            ,id: 2001
        }]
    },{
        title: '陕西'
        ,id: 3
        ,children: [{
            title: '西安'
            ,id: 3000
        },{
            title: '延安'
            ,id: 3001
        }]
    }]


    /**
     * 渲染区域弹出层
     * @param callback
     */
    var handleAreaLayer=function (callback) {
        //设备新增-区域选择
        $("#deviceArea").click(function (e) {
            var areaTree=areaTreeTpl.innerHTML;
            laytpl(areaTree).render(e,function (html) {
                var areaLayerIndex=layer.open({
                    type: 1,
                    offset:'100px',
                    move:false,
                    top:10,
                    title: '设备所在的区域',
                    content: html,
                    area: ['300px','430px']
                });
                tree.render({
                    elem: '#selectAreaTree'
                    ,data: data1
                    ,onlyIconControl: true  //是否仅允许节点左侧图标控制展开收缩
                    ,click: function(obj){
                        if (obj && typeof callback=="function"){
                            callback(obj.data)
                        }else {
                            layer.msg({
                                icon:2,
                                content:"选择的节点数据错误"
                            })
                        }
                        layer.close(areaLayerIndex);
                    }
                });
            })
        })
    }

    //获取选择区域的回调函数
    var getSelectedArea=function (data) {
        $("#deviceArea").val(data.title)
    }

    //初始化事件
    var initEvent=function () {
        //新增设备
        $("#addMonitorDevice").click(function (e) {
            var formTpl = addDeviceForm.innerHTML
            laytpl(formTpl).render(e, function(html){
                layer.open({
                    type: 1,
                    // offset:'10px',
                    move:false,
                    top:10,
                    title: '新增监测设备',
                    content: html,
                    btnAlign: 'c',
                    area: ['500px','550px'],
                    btn: ['保存', '重置'],
                    yes: function (index, layero) {
                        //按钮【按钮一】的回调
                        //保存菜单
                        $.ajax({
                            url: '/emims/api/monitorDevice',
                            type: 'post',
                            data: {
                                deviceMac: $("#deviceMac").val(),
                                code: $("#code").val(),
                                location: currentDeviceLocation,
                                deviceInfo: $("#deviceInfo").val()
                            },
                            success: function (data) {
                                layer.msg(data.message)
                                layer.close(index)
                                table.init('deviceTable', dataTableOptions);
                            }
                        })
                    },
                    btn2: function (index, layero) {
                        return false //开启该代码可禁止点击该按钮关闭
                    },
                    cancel: function () {},
                    success: function () {
                        //渲染区域选择元素
                        handleAreaLayer(getSelectedArea);
                    }
                });
            });
            layarea.render({
                elem: '#area-picker',
                change: function (res) {
                    //选择结果
                    console.log(res);
                    currentDeviceLocation=res.province+"/"+res.city+"/"+res.county
                }
            });
        })
    }

    var initPage=function(){
        //表格初始化
        table.init('deviceTable', dataTableOptions);

        //初始化区域搜索
        tree.render({
            elem: '#searchAreaTree'
            ,data: data1
            ,onlyIconControl: true  //是否仅允许节点左侧图标控制展开收缩
            ,click: function(obj){
                layer.msg(JSON.stringify(obj.data()))
            }
        });

        laydate.render({
            elem: '#createTime'
            ,type: 'datetime'
            ,range: true
        });

        initEvent();
    }

    initPage();

    var equipForm = "<div style='padding: 20px'>\n" +
        "        <form class=\"layui-form\" style='padding: 20px'>\n" +
        "            <div class=\"layui-form-item\">\n" +
        "                <label class=\"layui-form-label\">设备号</label>\n" +
        "                <div class=\"layui-input-block\">\n" +
        "                    <input class=\"layui-input\" name=\"deviceMac\" id=\"deviceMac\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"layui-form-item\">\n" +
        "                <label class=\"layui-form-label\">设备编码</label>\n" +
        "                <div class=\"layui-input-block\">\n" +
        "                    <input class=\"layui-input\" name=\"code\" id=\"code\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"layui-form-item\" id=\"area-picker\">\n" +
        "                <label class=\"layui-form-label\">区域</label>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <select name=\"province\" class=\"province-selector\" data-value=\"广东省\" lay-filter=\"province-1\">\n" +
        "                        <option>请选择省</option>\n" +
        "                    </select>\n" +
        "                </div>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <select name=\"city\" class=\"city-selector\" data-value=\"深圳市\" lay-filter=\"city-1\">\n" +
        "                        <option>请选择市</option>\n" +
        "                    </select>\n" +
        "                </div>\n" +
        "                <div class=\"layui-input-inline\">\n" +
        "                    <select name=\"county\" class=\"county-selector\" data-value=\"龙岗区\" lay-filter=\"county-1\">\n" +
        "                        <option>请选择区</option>\n" +
        "                    </select>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"layui-form-item\">\n" +
        "                <label class=\"layui-form-label\">设备信息</label>\n" +
        "                <div class=\"layui-input-block\">\n" +
        "                    <textarea style='width: 100%;height: 80px;border-color: #D2D2D2' name='deviceInfo' id='deviceInfo'></textarea>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </form>\n" +
        "    </div>";
    window.deleMonitorDevice = function () {
        layer.confirm('是否确认删除所选检测仪',
            {
                title:"删除",
                btn: ['删除', '取消'] //可以无限个按钮
            },
            function (index, layero) {
                //按钮【按钮一】的回调
                var deleteDevices = layui.table.checkStatus('deviceTable').data;
                var deleteDevicesIds = [];
                for (var i = 0; i < deleteDevices.length; i++) {
                    deleteDevicesIds.push(deleteDevices[i].deviceId)
                }
                $.ajax({
                    url: '/emims/api/monitorDevice/delete',
                    type: 'post',
                    data: {
                        deleteDeviceIds: deleteDevicesIds.join("-")
                    },
                    success: function (data) {
                        layer.msg(data.message)
                        table.init('deviceTable', dataTableOptions)
                    }
                })
            },
            function (index) {
                //按钮【按钮二】的回调
                layer.close(index)
            });
    }
});
