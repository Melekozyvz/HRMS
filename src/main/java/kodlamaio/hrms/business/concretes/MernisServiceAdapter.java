package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concrete.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdapter implements UserCheckService{

	@Override
	public Result checkRealPerson(Candidate candidate) {
		boolean result=false;
		KPSPublicSoapProxy kpsPublicSoapProxy=new KPSPublicSoapProxy();
		try {
			result=kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getTcNo()), 
					candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate().getYear());
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
		}
		if (result) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}
}
