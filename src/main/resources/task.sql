SELECT
    rel."familyName",
    rel."givenName",
    rel."middleName",
    rel."birthDate",
    dep."contactRelationship"
FROM
    "HPPersonGeneric" emp
JOIN
    "HPPersonDependant" dep ON emp."sysId" = dep."HPPersonGenericSysId"
JOIN
    "HPPersonGeneric" rel ON dep."HPRelatedPersonSysId" = rel."sysId"
WHERE
    emp."personId" = 'test';