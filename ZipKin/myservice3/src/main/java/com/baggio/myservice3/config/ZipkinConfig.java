package com.baggio.myservice3.config;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.EmptySpanCollectorMetricsHandler;
import com.github.kristofa.brave.Sampler;
import com.github.kristofa.brave.SpanCollector;
import com.github.kristofa.brave.http.DefaultSpanNameProvider;
import com.github.kristofa.brave.http.HttpSpanCollector;
import com.github.kristofa.brave.servlet.BraveServletFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZipkinConfig {
    @Bean
    public SpanCollector spanCollector() {
        HttpSpanCollector.Config spanConfig = HttpSpanCollector.Config.builder()
                .compressionEnabled(false)
                .connectTimeout(5000)
                .readTimeout(6000)
                .flushInterval(1)
                .build();

        // 这里的URL地址应该就是ZipKin的地址，可以考虑做成配置项
        return HttpSpanCollector.create("http://10.211.55.13:9411", spanConfig, new EmptySpanCollectorMetricsHandler());
    }

    @Bean
    public Brave brave(SpanCollector spanCollector) {
        // 这里指定了ZipKin上展示的我们这个服务的名称
        Brave.Builder builder = new Brave.Builder("myservice3");
        builder.spanCollector(spanCollector);
        // 这里定义了采集率，或者叫采样率
        builder.traceSampler(Sampler.create(1));

        return builder.build();
    }

    @Bean
    public BraveServletFilter braveServletFilter(Brave brave) {
        // spanName默认使用httpMethod的名字，例如：GET、POST
        return new BraveServletFilter(brave.serverRequestInterceptor(), brave.serverResponseInterceptor(), new DefaultSpanNameProvider());
    }
}
