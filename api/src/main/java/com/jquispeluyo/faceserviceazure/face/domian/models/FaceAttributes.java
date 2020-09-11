package com.jquispeluyo.faceserviceazure.face.domian.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceAttributes {
        private Double smile;
        private String gender;
        private Integer age;
        private String glasses;
        private Emotion emotion;
}
