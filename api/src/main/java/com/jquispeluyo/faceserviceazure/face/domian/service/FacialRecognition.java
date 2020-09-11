package com.jquispeluyo.faceserviceazure.face.domian.service;

import com.jquispeluyo.faceserviceazure.face.domian.models.Response;
import com.jquispeluyo.faceserviceazure.face.domian.models.Url;

import java.util.List;

public interface FacialRecognition {

    List<Response> byUrl (Url url);

}
