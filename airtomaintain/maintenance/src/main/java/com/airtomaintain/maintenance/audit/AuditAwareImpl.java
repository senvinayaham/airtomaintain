/**
 * 
 */
package com.airtomaintain.maintenance.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author senthilvinayahammurugan
 *
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("MAINTENANCE_MICROSERVICE");
	}

}
