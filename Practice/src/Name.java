import java.util.*;

public enum Name {
	Abhishek("Abhishek","Das"),Himani("Himani","Singhai"),Karan("Karan","Mood"),Deepthi("Deepthi","S");
	private  String firstName_;
	private String lastName_;
	private String fullName_;
	private Name(String firstName_,String lastName_){
		this.firstName_ = firstName_;
		this.lastName_ = lastName_;
		returnFullName();
		
	}

	public String returnFullName(){
		this.fullName_ = this.firstName_.concat(this.lastName_);
		return this.fullName_;
	}
	
}
