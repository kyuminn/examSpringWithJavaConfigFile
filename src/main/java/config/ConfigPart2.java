package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.dao.MemberDao;
import member.printer.MemberInfoPrinter;
import member.printer.MemberListPrinter;
import member.printer.MemberPrinter;
import member.printer.VersionPrinter;

@Configuration
public class ConfigPart2 {
//	// spring이 Bean annotation 붙은 메서드 확인 후 객체 생성, 의존객체 주입
//	// spring이 관리하는 객체는 모두 Singleton 패턴
//	// xml+xml 또는 xml+java code  또는 java code+ java code 여러 조합으로 설정파일을 지정할 수 있다!
//	// Factory pattern - 메소드 호출시 객체를 생성해서 반환
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
//	
//	@Bean
//	public MemberRegisterService memberRegSvc() {
//		return new MemberRegisterService(memberDao());
//	}
//	
//	@Bean
//	public ChangePasswordService changePwdSvc() {
//		return new ChangePasswordService(memberDao());
//	}
	
	
//	@Autowired
//	private MemberDao memberDao;
	
	@Autowired
	private ConfigPart1 configPart1;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(configPart1.memberDao(), printer());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(configPart1.memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
		
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(4);
		versionPrinter.setMinorVersion(1);
		return versionPrinter;
	}
	
	
}
