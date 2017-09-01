package Utilities;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;

/**
 * Created by mgough on 9/26/2014.
 */
public class XMLParser {

    private static HashMap<String,String> configurationMap;
    //private static ArrayList<ALMTestScript> testCaseMap;

    public static Document readXML(String args) { //returns true if the file is successfully read, otherwise false

            try {
                File xmlFile = new File(args);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                dbFactory.setIgnoringElementContentWhitespace(true);
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
                return doc;
            } catch (FileNotFoundException notFound) {
                //
                System.out.println("\nNo configuration file specified - using default configuration.");
                return null;
            } catch (Exception e) {
                System.out.println("\nFailed to load configuration file.");
                return null;
            }


    }

    @SuppressWarnings("rawtypes")
	public static HashMap initializeConfigurationMap(String filepathname) { //reminder: use the default map keys contained in the Parameters class

        Document configDocument = readXML(filepathname);
        configurationMap = new HashMap<String, String>();

        if (configDocument != null) {

            // Stubbing output for file read confirmation to clean up reports
            //System.out.println("\nSuccessful configuration file read... initializing configuration.");
            NodeList nodeList = configDocument.getChildNodes();

            parseXML(nodeList, configurationMap);

        }

        else
        { //if the config document cannot be parsed from the file for some reason, then the default configuration will be to run all tests with default parameters

            // Stubbing output for file read confirmation to clean up reports
            //System.out.println("\nLoading default parameters...");
            configurationMap.put("T001_KEY", "TRUE");
        }

        return configurationMap;
    }




    private static void parseXML(NodeList nodeList, HashMap<String,String> configurationMap) { //RECURSIVE node parser inserts elements into the configuration map
        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);
            String key = "";

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) { // parse each xml element node

                // get node name and value

                //System.out.println("Reading tag \"" + tempNode.getNodeName() + "\"");

                //translate xml node name to config map key
                if (tempNode.getNodeName().equals("parameter")){
                    key = "PARAMETER_";
                }
                else if (tempNode.getNodeName().equals("xpath")){
                    key = "XPATH_";
                }
                else if (tempNode.getNodeName().equals("test")){
                    key = "TEST_";
                }

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);

                        if (i == nodeMap.getLength() -1 ) {
                            // Stubbing output for xml element read confirmation to clean up reports
                            //System.out.println("Storing " + key + " as " + node.getNodeValue());
                            configurationMap.put(key,node.getNodeValue());

                        }
                        else{
                            key += node.getNodeValue();
                        }



                    }

                }

                if (tempNode.hasChildNodes()) {


                    // loop again if has child nodes

                    parseXML(tempNode.getChildNodes(), configurationMap);

                }

                //System.out.println("End Parsing " + tempNode.getNodeName());

            }
        }
    }

}

