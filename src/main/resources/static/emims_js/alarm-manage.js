layui.use(['element', 'form', 'table', 'laydate', 'layer'], function () {
    var element = layui.element;
    var form = layui.form;
    var table = layui.table;
    var layDate = layui.laydate;
    var layer = layui.layer;
    var $=layui.jquery;
    form.render();
    element.init();
    var cols =
        [
            [
                {checkbox: true},
                {field: 'title', title: '警报'},
                {field: 'alarmType', title: '类型'},
                {field: 'content', title: '内容'},
                {field: 'date', title: '时间'},
                {field: 'location', title: '位置'},
                {field: 'isReaded', title: '状态'}
            ]
        ];
    var dataTableOptions = {
        elem: '#message-all',
        url: '/emims/api/alarm/all',
        method: 'get',
        request: {
            pageName: 'page',
            limitName: 'size',
        },
        where: {
            start: '',
            end: '',
            searchText:''
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
            if (this.url == "/emims/api/alarm/new") {
                $("#alarmNum").html(count);
            }
        },
        text: {
            none: '暂无相关数据' //默认：无数据。注：该属性为 layui 2.2.5 开始新增
        }
    }
    //表格初始化
    table.init('message-all', dataTableOptions);
    dataTableOptions.url = "/emims/api/alarm/new";
    dataTableOptions.elem = "#message-new";
    table.init('message-new', dataTableOptions);

    layDate.render({
        elem: '#startDate' //指定元素
    });
    layDate.render({
        elem: '#endDate' //指定元素
    });
    window.loadByDate = function () {
        dataTableOptions.where.start = $("#startDate").val()
        dataTableOptions.where.end = $("#endDate").val()
        dataTableOptions.where.searchText = $("#searchText").val()
        dataTableOptions.url = "/emims/api/alarm/all";
        dataTableOptions.elem = "#message-all";
        table.init('message-all', dataTableOptions);
    }

});
