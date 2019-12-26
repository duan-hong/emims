package top.duanhong.emims.service.dataservice.remotedatahandle;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import top.duanhong.emims.pojo.tools.LogFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @author Administrator
 */
public class SocketServer{

    private Logger log= LogFactory.getLogger(SocketServer.class);

    /**
     * 解码buffer
     */
    private Charset cs = Charset.forName("UTF-8");
    /**
     * 接受数据缓冲区
     */
    private static ByteBuffer sBuffer = ByteBuffer.allocate(1024);
    /**
     * 发送数据缓冲区
     */
    private static ByteBuffer rBuffer = ByteBuffer.allocate(1024);
    /**
     * 选择器（叫监听器更准确些吧应该）
     */
    private static Selector selector;

    /**
     * 启动socket服务，开启监听,绑定端口
     *
     * @throws IOException
     */
    public void startSocketServer() {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            ServerSocket socket = channel.socket();
            socket.bind(new InetSocketAddress(8090));
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    handle(key);
                }
                keys.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 处理不同的事件
     *
     * @param selectionKey
     * @throws IOException
     */
    private void handle(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverChannel = null;
        SocketChannel channel = null;
        String remoteDataStr = "";
        int count = 0;
        if (selectionKey.isAcceptable()) {
            serverChannel = (ServerSocketChannel) selectionKey.channel();
            channel = serverChannel.accept();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            channel = (SocketChannel) selectionKey.channel();
            rBuffer.clear();
            count = channel.read(rBuffer);
            if (count > 0) {
                rBuffer.flip();
                remoteDataStr = String.valueOf(cs.decode(rBuffer).array());
            }
            log.info("远程数据"+remoteDataStr);
            if (StringUtils.isNotBlank(remoteDataStr)){
                //处理数据
                RemoteDataHandleService.acceptRemoteData(remoteDataStr);
            }else {
                log.info("接收的数据为空");
            }
            sBuffer = ByteBuffer.allocate(remoteDataStr.getBytes("UTF-8").length);
            sBuffer.put(remoteDataStr.getBytes("UTF-8"));
            sBuffer.flip();
            channel.write(sBuffer);
            channel.close();
        }
    }
}
