package base.commons.response;

/**
 * @author 01407975
 * @description 自定义返回结果集
 * @date 2021/12/9
 */
public class ResponseResult {

    private Object data;

    private Integer code;

    private String error;

    ResponseResult(Integer code){
        this.code = code;
    }

    public static ResponseResult ok(){
        return new ResponseResult(HttpStatus.OK.getValue());
    }

    public static ResponseResult ok( String error){
        ResponseResult responseResult = new ResponseResult(HttpStatus.OK.getValue());
        responseResult.setError(error);
        return  responseResult;
    }

    public static ResponseResult ok(Object object){
        ResponseResult responseResult = new ResponseResult(HttpStatus.OK.getValue());
        responseResult.setData(object);
        return  responseResult;
    }

    public static ResponseResult error(){
        return new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.getValue());
    }

    public static ResponseResult error(String message){
        ResponseResult responseResult = new ResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.getValue());
        responseResult.setError(message);
        return responseResult;
    }


    public static ResponseResult forbidden(){
        ResponseResult responseResult = new ResponseResult(HttpStatus.FORBIDDEN.getValue());
        responseResult.setError("认证失败，禁止访问!");
        return responseResult;
    }

    public static ResponseResult unauthorized(){
        ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.getValue());
        responseResult.setError("当前用户无访问权限!");
        return responseResult;
    }

    public static ResponseResult invalidToken(){
        ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.getValue());
        responseResult.setError("无效的TOKEN!");
        return responseResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object object) {
        this.data = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
