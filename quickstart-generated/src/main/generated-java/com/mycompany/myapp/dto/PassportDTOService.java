/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-angular:src/main/java/dto/EntityDTOService.java.e.vm
 */
package com.mycompany.myapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.domain.Passport;
import com.mycompany.myapp.domain.Passport_;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.dto.support.PageRequestByExample;
import com.mycompany.myapp.dto.support.PageResponse;
import com.mycompany.myapp.repository.PassportRepository;
import com.mycompany.myapp.repository.UserRepository;

/**
 * A simple DTO Facility for Passport.
 */
@Service
public class PassportDTOService {

    @Inject
    private PassportRepository passportRepository;
    @Inject
    private UserDTOService userDTOService;
    @Inject
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public PassportDTO findOne(Integer id) {
        return toDTO(passportRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<PassportDTO> complete(String query, int maxResults) {
        List<Passport> results = passportRepository.complete(query, maxResults);
        return results.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PageResponse<PassportDTO> findAll(PageRequestByExample<PassportDTO> req) {
        Example<Passport> example = null;
        Passport passport = toEntity(req.example);

        if (passport != null) {
            ExampleMatcher matcher = ExampleMatcher.matching() //
                    .withMatcher(Passport_.passportNumber.getName(), match -> match.ignoreCase().startsWith());

            example = Example.of(passport, matcher);
        }

        Page<Passport> page;
        if (example != null) {
            page = passportRepository.findAll(example, req.toPageable());
        } else {
            page = passportRepository.findAll(req.toPageable());
        }

        List<PassportDTO> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return new PageResponse<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    /**
     * Save the passed dto as a new entity or update the corresponding entity if any.
     */
    @Transactional
    public PassportDTO save(PassportDTO dto) {
        if (dto == null) {
            return null;
        }

        final Passport passport;

        if (dto.isIdSet()) {
            Passport passportTmp = passportRepository.findOne(dto.id);
            if (passportTmp != null) {
                passport = passportTmp;
            } else {
                passport = new Passport();
                passport.setId(dto.id);
            }
        } else {
            passport = new Passport();
        }

        passport.setPassportNumber(dto.passportNumber);

        passport.setExpirationDate(dto.expirationDate);

        if (dto.holder == null) {
            passport.setHolder(null);
        } else {
            User holder = passport.getHolder();
            if (holder == null || (holder.getId().compareTo(dto.holder.id) != 0)) {
                passport.setHolder(userRepository.findOne(dto.holder.id));
            }
        }

        return toDTO(passportRepository.save(passport));
    }

    /**
     * Converts the passed passport to a DTO.
     */
    public PassportDTO toDTO(Passport passport) {
        return toDTO(passport, 1);
    }

    /**
     * Converts the passed passport to a DTO. The depth is used to control the
     * amount of association you want. It also prevents potential infinite serialization cycles.
     *
     * @param passport
     * @param depth the depth of the serialization. A depth equals to 0, means no x-to-one association will be serialized.
     *              A depth equals to 1 means that xToOne associations will be serialized. 2 means, xToOne associations of
     *              xToOne associations will be serialized, etc.
     */
    public PassportDTO toDTO(Passport passport, int depth) {
        if (passport == null) {
            return null;
        }

        PassportDTO dto = new PassportDTO();

        dto.id = passport.getId();
        dto.passportNumber = passport.getPassportNumber();
        dto.expirationDate = passport.getExpirationDate();
        if (depth-- > 0) {
            dto.holder = userDTOService.toDTO(passport.getHolder(), depth);
        }

        return dto;
    }

    /**
     * Converts the passed dto to a Passport.
     * Convenient for query by example.
     */
    public Passport toEntity(PassportDTO dto) {
        return toEntity(dto, 1);
    }

    /**
     * Converts the passed dto to a Passport.
     * Convenient for query by example.
     */
    public Passport toEntity(PassportDTO dto, int depth) {
        if (dto == null) {
            return null;
        }

        Passport passport = new Passport();

        passport.setId(dto.id);
        passport.setPassportNumber(dto.passportNumber);
        passport.setExpirationDate(dto.expirationDate);
        if (depth-- > 0) {
            passport.setHolder(userDTOService.toEntity(dto.holder, depth));
        }

        return passport;
    }
}