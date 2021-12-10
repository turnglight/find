package find.cloud.type.response;

/**
 * @author 01407975
 * @description 自定义返回结果集
 * @date 2021/12/9
 */
public class ResponseResult {

    private Object object;

    private Integer total;

    private Integer code;

    private String error;

    ResponseResult(Integer code){
        this.code = code;
    }

    public static ResponseResult ok(){
        return new ResponseResult(HttpStatus.OK.getValue());
    }

    public static ResponseResult ok(Object object){
        ResponseResult responseResult = new ResponseResult(HttpStatus.OK.getValue());
        responseResult.setObject(object);
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

    public static ResponseResult unauthorized(){
        return new ResponseResult(HttpStatus.UNAUTHORIZED.getValue());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
