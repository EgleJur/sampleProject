package com.example.startingProject.validationUnits;

import com.example.startingProject.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ValidationUtilsNotNull {

    private static final Logger logger = LogManager.getLogger(ValidationUtilsNotNull.class);

    public static void isValidById(Long id) {
        if (id == null || id.equals("")) {
            throw new ValidationException("Id cannot be empty", "id",
                    "Id is empty", String.valueOf(id));
        }
    }
    public static void isValidByName(String name) {
        if (name == null || name.isEmpty() || name.equals("")) {
            logger.warn("Name was not given");
            throw new ValidationException("Name can not be empty", "name",
                    "Name is empty", name);
        }
    }

}

