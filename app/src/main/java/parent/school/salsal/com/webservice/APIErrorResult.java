package parent.school.salsal.com.webservice;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class APIErrorResult
{
    @SerializedName ("code")
    private Integer code;

    @SerializedName ("msg")
    private JsonElement msg;

    public Integer getCode()
    {
        return code;
    }

    public String getMessage()
    {
        if (msg != null && msg.isJsonPrimitive())
        {
            return msg.getAsString();
        } else if (msg == null)
        {
            return "خطا رخ داده، لطفا مجدد سعی کنید";
        } else
        {
            String message = "";

            if (msg.getAsJsonObject().has("verify_code"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("verify_code").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("verify_code").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("loaderNameId"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("loaderNameId").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("loaderNameId").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("nationalCode"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("nationalCode").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("nationalCode").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("bankCardNumber"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("bankCardNumber").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("bankCardNumber").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("name"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("name").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("name").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("family"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("family").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("family").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("mobile"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("mobile").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("mobile").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("shipmentTitleId"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("shipmentTitleId").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("shipmentTitleId").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("packagingTypeId"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("packagingTypeId").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("packagingTypeId").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("contemplateLoadingDate"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("contemplateLoadingDate").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("contemplateLoadingDate").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            if (msg.getAsJsonObject().has("postalCode"))
            {
                for (int i = 0; i < msg.getAsJsonObject().get("postalCode").getAsJsonArray().size(); i++)
                {
                    message += msg.getAsJsonObject().get("postalCode").getAsJsonArray().get(i).toString() + "\n";

                }

            }
            return message;
        }
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public void setMessage(JsonElement message)
    {
        msg = message;
    }


}
