package com.wangby.filterchain;

import java.util.ArrayList;
import java.util.List;

public class Servlet_Main {

    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:), <script>, 欢迎访问 mashibing.com, 大家都是996";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HtmlFilter())
                .add(new SensitiveFilter());
        chain.doFilter(request, response, chain);
        System.out.println(request.str);
        System.out.println(response.str);
    }

}

class Request {
    String str;
}

class Response {
    String str;
}

interface  Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + " HTMLFILTER";
        chain.doFilter(request, response, chain);
        response.str += "--HTMLFILTER";
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "995") + " SENSITIVEFILTER";
        chain.doFilter(request, response, chain);
        response.str += "--SensitiveFilter";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> list = new ArrayList<Filter>();
    int index = 0;

    public FilterChain add(Filter filter) {
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == list.size()) return false;
        Filter f = list.get(index);
        index++;
        return f.doFilter(request, response, this);
    }
}
