public class StringProcessor {
    public static String Process(String input){
        String output = input.replaceAll("\\$","%24").replaceAll("-","%2D")
                .replaceAll("_","%5F").replaceAll("\\.","%2E")
                .replaceAll("\\+","%2B").replaceAll("!","%21")
                .replaceAll("\\*","%2A").replaceAll("\"","%22")
                .replaceAll("'","%27").replaceAll("\\(","%28")
                .replaceAll("\\)","%29").replaceAll(";","%3B")
                .replaceAll("/","%2F").replaceAll("\\?","%3F")
                .replaceAll(":","%3A").replaceAll("@","%40")
                .replaceAll("=","%3D").replaceAll("&","%26")
                .replaceAll("\\|","%7C");
        //processing string to fit in Google query URL
        //more info:https://developers.google.com/custom-search/docs/xml_results_appendices?hl=en#url-escaping
        output = output.replaceAll("`","%60").replaceAll("\\\\","%5C")
                .replaceAll("#", "%23").replaceAll("\\^", "%5E")
                .replaceAll("\\[", "%5B").replaceAll("]", "%5D")
                .replaceAll("\\{", "%7B").replaceAll("}", "%7D")
                .replaceAll(" ", "+");
        //characters that are not in the linked doc, figured out myself how to replace them
        return output;
    }
}
