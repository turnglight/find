package base.web.response;

/**
 * @author 01407975
 * @description 分页响应结构
 * @date 2021/12/20
 */
public class PageResponseResult extends ResponseResult {

    private Long total;

    PageResponseResult(Integer code) {
        super(code);
    }

    public static PageResponseResult ok(){
        return new PageResponseResult(200);
    }

    public static PageResponseResult ok(Object data, Long total){
        PageResponseResult pageResult = new PageResponseResult(200);
        pageResult.setData(data);
        pageResult.setTotal(total);
        return pageResult;
    }

    public static PageResponseResult error(){
        return new PageResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.getValue());
    }

    public static PageResponseResult error(String message){
        PageResponseResult pageResult = new PageResponseResult(HttpStatus.INTERNAL_SERVER_ERROR.getValue());
        pageResult.setError(message);
        return pageResult;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
