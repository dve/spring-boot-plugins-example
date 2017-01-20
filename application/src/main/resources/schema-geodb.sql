-- Initializes the spatial features in geodb
CREATE ALIAS InitGeoDB for "geodb.GeoDB.InitGeoDB";
CALL InitGeoDB();