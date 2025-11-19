package carril.danel.convertidor;

public interface Converter {
    String toCsv(String input) throws Exception;
    String toJson(String input) throws Exception;
    String toXml(String input) throws Exception;
}
