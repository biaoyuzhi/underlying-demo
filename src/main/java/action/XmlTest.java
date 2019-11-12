package action;

import org.apache.commons.digester3.Digester;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pojo.Man;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by wuzh on 2019/10/31.
 * Describe: 使用JDK自带的方法来解析xml文件。常用解析方式：dom、sax、pull 解析
 * 最后面一个使用Apache的commons项目中Digester项目将xml文件解析成Java对象(Tomcat7.0.67就是使用的Digester解析conf/server.xml)：pom.xml中引入依赖commons-digester3
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
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
//            System.out.println(node.getNodeName());
            if ("bean".equals(node.getNodeName())) {
                //获取儿子标签下的孙子标签
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node item = childNodes.item(j);
                    if (3 != item.getNodeType()) {
                        //获取孙子标签的所有键值对属性
                        NamedNodeMap attributes = item.getAttributes();
                        for (int k = 0; k < attributes.getLength(); k++)
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
        parser.parse(xmlFile, new DefaultHandler() {
            //碰到开始标签执行
            //qName为标签名称，attributes为标签中的键值对属性
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println(qName);
                for (int i = 0; i < attributes.getLength(); i++)
                    System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
            }

            //碰到结束标签执行
            @Override
            public void endElement(String uri, String localName, String qName) {
//                System.out.println(qName);
            }

            //碰到文本执行
            //characters方法中的ch把所解析的xml的所有数据都保存进来，且ch初始化为2K数据。 start是一个节点">"的位置。length就是">"到下一个"<"的长度。即一对标签之间的文本
            @Override
            public void characters(char ch[], int start, int length) {
                System.out.println(new String(ch, start, length));
            }
        });

        /**
         * 使用Apache的commons项目中Digester项目将xml文件解析成Java对象
         */
        Man man = new DigesterRule().execute("man.xml");
        System.out.println("+++++++++++++" + man.getMessage());
    }

}

/**
 * 配置Digester的解析规则
 */
class DigesterRule {
    public Man execute(String filePath) throws IOException, SAXException {
        Digester digester = new Digester();
        //是否要对XML文档进行有效性验证，默认值为false
        digester.setValidating(false);
        //创建对象
        digester.addObjectCreate("school/classes/class/man", Man.class);
        //1、设置属性，直接按标签的名称来映射对象的属性(如果该设置和下面设置同时启用，该设置优先级更高)
//        digester.addBeanPropertySetter("school/classes/class/man/name");
//        digester.addBeanPropertySetter("school/classes/class/man/age");
//        digester.addBeanPropertySetter("school/classes/class/man/message");
        //2.1、将标签中的键值对映射为对象的属性
//        digester.addSetProperties("school/classes/class/man","name","name");    //第2个参数为标签中的键值对名，第3个参数为对象中的属性名
//        digester.addSetProperties("school/classes/class/man","age","age");
//        digester.addSetProperties("school/classes/class/man","message","message");
        //2.2、如果键值对名与属性名称是一致的，可以直接使用下面一条语句
        digester.addSetProperties("school/classes/class/man");
        //创建对象之间的关系。将后面一个对象作为参数传入前面一个对象的某个方法时，可以调用addSetNext方法来指定这个对象之间的关系
//        digester.addSetNext("school/classes/class/man","addMan"); //即将man对象作为参数添加进class对象的addMan()方法中
        URL url = this.getClass().getClassLoader().getResource(filePath);
        return digester.parse(url);
    }
}