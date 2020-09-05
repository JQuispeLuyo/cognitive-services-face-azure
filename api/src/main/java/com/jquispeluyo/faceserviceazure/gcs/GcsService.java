package com.jquispeluyo.faceserviceazure.gcs;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GcsService {
    String upload (MultipartFile obj) throws IOException;
}
