package com.ssglobal.revalida.jibe.service;

import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.domain.Follow;
import com.ssglobal.revalida.jibe.model.FollowDTO;
import com.ssglobal.revalida.jibe.repository.FollowRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

@Service
public class FollowService {

	private final FollowRepository followRepository;

	public FollowService(final FollowRepository followRepository) {
		this.followRepository = followRepository;
	}

    public FollowDTO get(final Integer followID) {
        return followRepository.findById(followID)
                .map(follow -> mapToDTO(follow, new FollowDTO()))
                .orElseThrow(NotFoundException::new);
    }
    
    public Integer create(final FollowDTO followDTO) {
        final Follow follow = new Follow();
        mapToEntity(followDTO, follow);
        return followRepository.save(follow).getFollowID();
    }

	public void delete(final Integer followID) {
		followRepository.deleteById(followID);
	}

	private FollowDTO mapToDTO(final Follow follow, final FollowDTO followDTO) {
		followDTO.setFollowID(follow.getFollowID());
		followDTO.setFollowerID(follow.getFollowerID());
		followDTO.setFolloweeID(follow.getFolloweeID());
		return followDTO;
	}

	private Follow mapToEntity(final FollowDTO followDTO, final Follow follow) {
		follow.setFollowerID(followDTO.getFollowerID());
		follow.setFolloweeID(followDTO.getFolloweeID());
		return follow;
	}
}
