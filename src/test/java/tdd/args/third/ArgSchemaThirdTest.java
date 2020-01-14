package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgSchemaThirdTest {

    @Test
    public void should_return_normal_value_with_normal_param() {
        assertEquals(new ArgSchemaThird("p:int;l:bool").get("p").getValue("8080"), 8080);
        assertEquals(new ArgSchemaThird("p:int;l:bool").get("l").getValue("true"), Boolean.TRUE);
    }

    @Test
    public void should_return_default_value_with_null_param() {
        assertEquals(new ArgSchemaThird("p:int;l:bool").get("p").getValue(null), 0);
        assertEquals(new ArgSchemaThird("p:int;l:bool").get("l").getValue(null), Boolean.TRUE);
    }

}
