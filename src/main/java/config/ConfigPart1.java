package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.dao.MemberDao;
import member.printer.MemberInfoPrinter;
import member.printer.MemberListPrinter;
import member.printer.MemberPrinter;
import member.printer.VersionPrinter;
import member.service.ChangePasswordService;
import member.service.MemberRegisterService;

@Configuration
public class ConfigPart1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDao());
	}
	
// ConfigPart2 로 나눠질 내용
//	@Bean
//	public MemberPrinter printer() {
//		return new MemberPrinter();
//	}
//	
//	@Bean
//	public MemberListPrinter listPrinter() {
//		return new MemberListPrinter(memberDao(), printer());
//	}
//	
//	@Bean
//	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setMemberPrinter(printer());
//		return infoPrinter;
//		
//	}
//	
//	@Bean
//	public VersionPrinter versionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
//		versionPrinter.setMajorVersion(4);
//		versionPrinter.setMinorVersion(1);
//		return versionPrinter;
//	}
	
	
}
