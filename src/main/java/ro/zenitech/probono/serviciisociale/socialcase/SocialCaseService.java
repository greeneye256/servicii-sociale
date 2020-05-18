package ro.zenitech.probono.serviciisociale.socialcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;
import ro.zenitech.probono.serviciisociale.beneficiary.BeneficiaryRepository;
import ro.zenitech.probono.serviciisociale.beneficiary.BeneficiaryService;
import ro.zenitech.probono.serviciisociale.beneficiary.relative.Relative;
import ro.zenitech.probono.serviciisociale.beneficiary.relative.RelativeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SocialCaseService {

    SocialCaseRepository socialCaseRepository;
    BeneficiaryRepository beneficiaryRepository;
    RelativeRepository relativeRepository;

    @Autowired
    public SocialCaseService(SocialCaseRepository socialCaseRepository, BeneficiaryRepository beneficiaryRepository, RelativeRepository relativeRepository) {
        this.socialCaseRepository = socialCaseRepository;
        this.beneficiaryRepository = beneficiaryRepository;
        this.relativeRepository = relativeRepository;
    }

    public SocialCase saveSocialCase(SocialCase socialCase) {
        List<Relative> relatives = socialCase.getBeneficiary().getRelatives();
        Beneficiary beneficiary = socialCase.getBeneficiary();
        beneficiary.setRelatives(null);
        beneficiary = beneficiaryRepository.saveAndFlush(beneficiary);
        socialCase.setBeneficiary(beneficiary);
        for (Relative rel: relatives
             ) {
            rel.setBeneficiary(beneficiary);
            relativeRepository.saveAndFlush(rel);
        }
        return socialCaseRepository.saveAndFlush(socialCase);
    }
}
