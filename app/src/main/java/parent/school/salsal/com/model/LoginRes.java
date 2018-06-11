package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class LoginRes {
    /**
     * msg : ok
     * data : {"user_id":1,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImlzcyI6Imh0dHA6Ly9hcGkuc2Fsc2FsLmxvY2FsL2FwaS92MS91c2VyL3NpZ25pbiIsImlhdCI6MTUyNjI3NTQ2OCwiZXhwIjoxNTI2Mjc5MDY4LCJuYmYiOjE1MjYyNzU0NjgsImp0aSI6InhwODFYY1hNbnBEN1FaT2IifQ.r3n6_Bs2Yrri9ZO7MKgVx8JRQH6L3fH17OUDErNeLBc"}
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 1
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsImlzcyI6Imh0dHA6Ly9hcGkuc2Fsc2FsLmxvY2FsL2FwaS92MS91c2VyL3NpZ25pbiIsImlhdCI6MTUyNjI3NTQ2OCwiZXhwIjoxNTI2Mjc5MDY4LCJuYmYiOjE1MjYyNzU0NjgsImp0aSI6InhwODFYY1hNbnBEN1FaT2IifQ.r3n6_Bs2Yrri9ZO7MKgVx8JRQH6L3fH17OUDErNeLBc
         */

        @SerializedName("user_id")
        private String userId;
        @SerializedName("token")
        private String token;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
