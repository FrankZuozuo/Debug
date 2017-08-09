package debug.debug;

/**
 * 配置debug模式下的数据
 */
public enum DebugConst {

	HostName("host-name"), 
	Password("password-123"), 
	Count(100), 
	IsAdmin(true),

	;

	private Object value;

	DebugConst(Object value) {
		this.value = value;
	}

	public Integer intValue() {
		return (Integer) value;
	}

	public Byte byteValue() {
		return (Byte) value;
	}

	public Short shortValue() {
		return (Short) value;
	}

	public Long longValue() {
		return (Long) value;
	}

	public Float floatValue() {
		return (Float) value;
	}

	public Double doubleValue() {
		return (Double) value;
	}

	public boolean booleanValue() {
		return (boolean) value;
	}

	public Object objectValue() {
		return value;
	}
	
	public String stringValue() {
		return (String)value;
	}

}
