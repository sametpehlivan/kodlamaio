package core.validation;


import entites.BaseEntity;

import java.util.List;

public interface IValidation<T extends BaseEntity>
{
    void validate(T data) throws Exception;
    void validateAll(List<T> data) throws Exception;
}
