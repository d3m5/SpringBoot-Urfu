package ru.d3m5.rest1.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.d3m5.rest1.model.Request;
import ru.d3m5.rest1.model.SystemName;
import ru.d3m5.rest1.util.DateTimeUtil;

import java.util.Date;


@Service
@Primary
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        String currentDate = String.valueOf(new Date().getTime());
        request.setSystemName(SystemName.Service1);
        request.setSystemTime(currentDate);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
