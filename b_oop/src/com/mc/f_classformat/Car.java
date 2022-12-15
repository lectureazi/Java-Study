package com.mc.f_classformat;

public class Car {
	
	//클래스 : 속성 + 기능
	//		   필드 + 지역
	
	// 필드 : 지역이 아닌 영역, 메서드 바깥 영역, 필드에 존재하는 것(변수, 메서드)들을 클래스의 멤버
	
	// 필드에 선언되는 변수 => 필드변수(멤버변수)
	//						  값을 명시적으로 할당하지 않으면, JVM 기본값으로 초기화 됩니다.
	
	//						인스턴스 변수 : non static 변수
	//										클래스가 인스턴스화 되는 시점에 초기화 되는 변수
	//										같은 클래스 이더라도 인스턴스마다 값이 개별적이다.
	
	//						클래스 변수	  : static 변수
	//										클래스가 메모리에 올라가는 시점에 초기화 되는 변수
	//										클래스의 인스턴스들이 모두 공유하는 값을 저장
	
	
	// 지역 : 메서드 내부, 메서드가 호출부에 의해서 호출되는 시점에 메모리에 올라가고
	//		  메서드 실행이 끝나고 호출부로 돌아가는 시점에 메모리에서 내려간다.
	
	//		  매개변수 : 호출부에서 전달하는 값(전달인자)을 받기 위해 메서드의 선언부에 선언되는 변수
	//		  지역변수 : 메서드 내부에서 선언된 변수, 초기화를 해야지만 사용할 수 있다.
	
	//인스턴스 변수
	private String name;
	private String color;
	private int speed;
	
	//클래스 변수
	private static final int MAX_SPEED = 250;
	private static int afterServicePeriod;
	
	//초기화 순서
	// 인스턴스변수 : jvm기본값  > 직접 할당한 값 > 초기화 블록 > 생성자
	// 클래스 변수 :  jvm 기본값 > 직접 할당한 값 > static 초기화 블록
	
	{
		
		System.out.println("JVM 기본값 확인 : " + name);
		
		name = "산타페";
		color = "red";
		speed = 0;
		
		System.out.println("초기화 블록 이후 값 : " + name);
		System.out.println("===================================================");
	}
	
	static {
		System.out.println("=================초기화 순서 확인==================");
		System.out.println("static JVM 기본값 확인 : " + afterServicePeriod);
		
		afterServicePeriod = 24;
		
		System.out.println("static 초기화 블록 이후 값 : " + afterServicePeriod);
		System.out.println("===================================================");
	}
	
	
	// 생성자 : 클래스를 인스턴스화 할 때 호출하는 메서드
	//			클래스 이름과 같은 이름을 가진 메서드
	//			기본생성자(매개변수가 없는 생성자)는 명시적으로 작성하지 않아도, JVM이 기본생성자를 자동으로 만들어 준다.
	
	// this : 생성된 인스턴스의 주소를 저장하는 특수한 레퍼런스
	// super : 부모 인스턴스의 주소를 저장하는 특수한 레퍼런스
	// this(args) : 자기 자신의 생성자를 호출
	// super(args) :  부모클래스의 생성자를 호출
	//				  생성자 내에서, 부모클래스의 생성자를 호출하는 코드를 작성하지 않을 경우 
	//				  super() 코드(부모클래스의 기본생성자)를 JVM이 자동으로 생성
	//				  만약 부모클래스에 기본생성자가 없고, 매개변수가 있는 생성자만 존재한다면
	//				  반드시 부모클래스의 생성자를 호출하는 코드를 작성 해야한다.
	
	public Car() {
		super();
		speed = 0;
		System.out.println("기본생성자 호출");
	}
	
	public Car(String name, String color) {
		this(); //자기 생성자를 호출
		this.name = name;
		this.color = color;
		System.out.println("this에 담긴 값 확인 :" + this);
		System.out.println("super에 담긴 값 확인 :" + super.toString());
	}
	
	
	//캡슐화
	// 클래스에서 숨길 것과 드러낼 것을 결정하여 추상성을 확보하는 과정
	// 필드변수 : 필드변수의 접근제한자를 private으로 지정해 외부에서 필드변수에 직접 접근하는 것을 차단하고
	//			  getter/setter 를 통해서만 필드변수에 접근하는 것을 허용하는 것.
	//			  멤버변수에 대한 접근권한을 관리할 수 있다.
	//			  getter/setter : 읽기, 쓰기   getter : 읽기    getter/setter 미작성 : 접근 금지
	
	// 메서드 :   외부에서 메세지를 전달 받는 용도의 public메서드와, 세부적인 기능을 구현하는 private 메서드를 분리
	//			  클래스간 결합도를 낮춰 유연한 설계를 가능하게 해줌
	//			  클래스의 구체적인 기능을 감추는 추상화를 통해 유연성을 확보

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public static int getAfterServicePeriod() {
		return afterServicePeriod;
	}

	public static void setAfterServicePeriod(int afterServicePeriod) {
		Car.afterServicePeriod = afterServicePeriod;
	}

	public static int getMaxSpeed() {
		return MAX_SPEED;
	}
	
	//Override : 부모클래스부터 상속받은 메서드를 재정의 하는 것
	
	//			 - 부모 클래스에 선언된 메서드의 접근제한자보다 넓은 범위의 접근제한자로 변경할 수 있다.
	//			하지만 좁은 범위의 접근제한자로 변경하는 것은 불가능하다.
	
	//			 - 부모 클래스에서 throw하고 있는 예외클래스를 해당 예외클래스의 선조클래스로 바꿔 throw하는 것은 가능하다.
	
	//			 - private메서드는 private 필드변수와 마찬가지로 상속되지 않기 때문에, Override 할 수도 없다.

	//			 - static메서드는 상속이 안된다. 따라서 Override도 할 수 없다.
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", speed=" + speed + "]";
	}
	
	
	
	
	
	
	

}
