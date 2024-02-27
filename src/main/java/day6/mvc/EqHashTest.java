package day6.mvc;

import java.util.Objects;

public class EqHashTest {

	public static void main(String[] args) {
		
		RequestMap2 reqMap1 = new RequestMap2("save", "GET");
		RequestMap2 reqMap2 = new RequestMap2("save", "GET");
	
		System.out.println("reqMap1 == reqMap2 : "+ (reqMap1 == reqMap2));
		System.out.println("reqMap1.equals(reqMap2) : "+ (reqMap1.equals(reqMap2)));
		System.out.println("reqMap1.hashCode() ==  reqMap2.hashCode(): "+ (reqMap1.hashCode() ==  reqMap2.hashCode()));
		// Map은 Key 값으로 Value를 찾아옵니다
		// 	ㄴ url 과 method가 둘다 문자열인데
		//		문자열이 같으면 동일한 key값으로 취급되어야 합니다.
			
		// RequestMap2 객체에 euqlas와 hascode 메소드를 재정의하였을 때
//		reqMap1 == reqMap2 : false
//		reqMap1.equals(reqMap2) : true
//		reqMap1.hashCode() ==  reqMap2.hashCode(): true
		
		// RequestMap2 객체에 euqlas와 hascode 메소드를 재정의하지 않았을 때
//		reqMap1 == reqMap2 : false
//		reqMap1.equals(reqMap2) : false
//		reqMap1.hashCode() ==  reqMap2.hashCode(): false		
		
	}

}


class RequestMap2 {
	private String url;
	private String method;
	
	public RequestMap2(String url, String method) {
		this.url = url;
		this.method = method;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

	// 비교되는 2개 객체가 각각 new 연산으로 만들어지면 해시코드가 다릅니다
	@Override
	public int hashCode() {		// 해시코드값 재정의 : method와 url 참조값으로 계산한 것 리턴
		// 다른 객체 other 와 url, method 문자열이 같으면 같은 해시코드값을 리턴합니다
		return Objects.hash(method, url);
	}

	@Override
	public boolean equals(Object obj) {		// obj 변수는 현재 객체와 비교되는 다른 객체입니다
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestMap2 other = (RequestMap2) obj;
		
		// 다른 객체 other와 url과 method 문자열이 같으면 'True'(1)를 리턴합니다
		return Objects.equals(method, other.method) && Objects.equals(url, other.url);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}