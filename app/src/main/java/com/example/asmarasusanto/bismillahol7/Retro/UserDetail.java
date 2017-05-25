package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asmarasusanto on 5/19/17.
 */
public class UserDetail {

    @SerializedName("status") public String status;

    @SerializedName("message") public String message;

    @SerializedName("user_id") public String idUser;

    @SerializedName("user_name") public String nameUser;

    @SerializedName("token") public String tokenUser;

    @SerializedName("email") public String emailUser;

    @SerializedName("omniKey") public String omniUser;

    @SerializedName("confirmed") public Boolean confirmedStatus;

}
