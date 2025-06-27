package henrotaym.env.services;

import henrotaym.env.dto.request.ActionRequest;
import henrotaym.env.dto.response.ActionResponse;
import henrotaym.env.entities.Action;
import henrotaym.env.mappers.ActionMapper;
import henrotaym.env.mappers.OptionalMapper;
import henrotaym.env.repositories.ActionRepository;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ActionService {
    private ActionRepository actionRepository;
    private ActionMapper actionMapper;
    private OptionalMapper optionalMapper;

    public ActionService(
            ActionRepository actionRepository,
            ActionMapper actionMapper,
            OptionalMapper optionalMapper) {
        this.actionRepository = actionRepository;
        this.actionMapper = actionMapper;
        this.optionalMapper = optionalMapper;
    }

    public void save(ActionRequest actionRequest) {
        Action actionToSave = actionMapper.toEntity(actionRequest);
        actionRepository.save(actionToSave);
    }

    public Optional<ActionResponse> findById(BigInteger id) {
        Optional<Action> actionFound = actionRepository.findById(id);
        return optionalMapper.mapOptional(actionFound, actionMapper::fromEntity);
    }

    public Optional<ActionResponse> update(BigInteger id, ActionRequest actionRequest) {
        Action action = actionMapper.toEntity(actionRequest);

        return actionRepository
                .findById(id)
                .map(
                        existingAction -> {
                            existingAction.setName(action.getName());
                            existingAction.setDue_at(action.getDue_at());
                            existingAction.setPlant(action.getPlant());
                            Action saved = actionRepository.save(existingAction);
                            return actionMapper.fromEntity(saved);
                        });
    }

    public void deleteById(BigInteger id) {
        if (actionRepository.existsById(id)) {
            actionRepository.deleteById(id);
        }
    }
}
