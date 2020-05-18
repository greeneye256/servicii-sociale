package ro.zenitech.probono.serviciisociale.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    public List<Beneficiary> findAll(){
        return beneficiaryRepository.findAll();
    }

    public Beneficiary findBeneficiaryById(Long id){
        return beneficiaryRepository.getOne(id);
    }

    public Beneficiary saveBeneficiary(Beneficiary beneficiary){
        return beneficiaryRepository.saveAndFlush(beneficiary);
    }

}
