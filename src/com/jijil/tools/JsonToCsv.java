package com.jijil.tools;

public class JsonToCsv {

/*    public static void main(String[] args) {
        JsonNode jsonTree = new ObjectMapper().readTree(new File("src/main/resources/orderLines.json"));
        //Create csv schema
        Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        //Create csv mapper

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File("src/main/resources/orderLines.csv"), jsonTree);

    }*/
}
