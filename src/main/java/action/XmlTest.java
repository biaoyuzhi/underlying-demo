package action;

import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by wuzh on 2019/10/31.
 * Describe: 使用JDK自带的方法来解析xml文件。常用解析方式：dom、sax、pull 解析
 */
public class XmlTest {
    public static void main(String[] args) throws Exception {
        String xmlPath = "src/main/resources/bean.xml";
        File xmlFile = new File(xmlPath);

        /**
         * dom (Document Object Mode)解析
         * 其缺点是 dom 解析时会把整个 xml 映射成doc 树状对象，对于大的 xml 文件，会造成占用内存大，查找慢的问题。
         * 在 dom 结构中节点类型分三种，元素节点、属性节点、文本节点，可以通过 getNodeType() 方法判断，返回值 1、2、3 分别对应这三种类型。
         */
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        //获得根目录
        Element element = document.getDocumentElement();
        //获得所有儿子标签
        NodeList nodes = element.getChildNodes();
        for (int i=0;i<nodes.getLength();i++){
            Node node = nodes.item(i);
//            System.out.println(node.getNodeName());
            if ("bean".equals(node.getNodeName())){
                //获取儿子标签下的孙子标签
                NodeList childNodes = node.getChildNodes();
                for (int j=0;j<childNodes.getLength();j++){
                    Node item = childNodes.item(j);
                    if (3 != item.getNodeType()){
                        //获取孙子标签的所有键值对属性
                        NamedNodeMap attributes = item.getAttributes();
                        for (int k=0;k<attributes.getLength();k++)
                            System.err.println(attributes.item(k).getNodeName() + ":" + attributes.item(k).getNodeValue());
                    }
                }
            }
        }
        /**
         * sax (Simple API for XML)解析，一种以事件驱动的形式进行解析
         * 其缺点是只能进行 xml 文件的读取，不能写，而且一开始解析就必须解析到结束，不能中途停止。
         */
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(xmlFile, new DefaultHandler(){
            //碰到开始标签执行
            //qName为标签名称，attributes为标签中的键值对属性
            @Override
            public void startElement (String uri, String localName,String qName, Attributes attributes){
                System.out.println(qName);
                for (int i=0;i<attributes.getLength();i++)
                    System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
            }
            //碰到结束标签执行
            @Override
            public void endElement(String uri, String localName, String qName){
//                System.out.println(qName);
            }
            //碰到文本执行
            //characters方法中的ch把所解析的xml的所有数据都保存进来，且ch初始化为2K数据。 start是一个节点">"的位置。length就是">"到下一个"<"的长度。即一对标签之间的文本
            @Override
            public void characters(char ch[], int start, int length){
                System.out.println(new String(ch, start, length));
            }
        });

    }
}
