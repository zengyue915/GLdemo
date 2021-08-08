package demo.vo;

import demo.enums.ResponseEnum;
import junit.framework.TestCase;
import org.junit.Test;

public class ResponseVoTest extends TestCase {
    @Test
    public void testSuccessByMsg() {
        ResponseVo actual = ResponseVo.successByMsg("hello");
        ResponseVo expected = new ResponseVo(0, "hello");
        assertEquals(expected, actual);
    }

    @Test
    public void testSuccess() {
        ResponseVo actual = ResponseVo.success();
        ResponseVo expected = new ResponseVo(0, "Succeed");
        assertEquals(expected, actual);
    }

    @Test
    public void testError() {
        ResponseVo actual = ResponseVo.error(ResponseEnum.values()[0]);
        ResponseVo expected = new ResponseVo(-1, "Server Error");
        assertEquals(expected, actual);
    }

}