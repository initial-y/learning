package tdd.args.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgSchemaThirdTest {

    @Test
    public void should_return_normal_value_with_normal_param() {
        assertEquals(new ArgSchemaThird("p:int;l:bool").getValue("p", "8080"), 8080);
        assertEquals(new ArgSchemaThird("p:int;l:bool").getValue("l", "true"), Boolean.TRUE);
    }

    @Test
    public void should_return_default_value_with_null_param() {
        assertEquals(new ArgSchemaThird("p:int;l:bool").getValue("p", null), 0);
        assertEquals(new ArgSchemaThird("p:int;l:bool").getValue("l", null), Boolean.TRUE);
    }

}
