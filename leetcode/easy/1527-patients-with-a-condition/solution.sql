# Write your MySQL query statement below
-- select patient_id,
--        patient_name,
--        conditions
-- from Patients
-- where  conditions like "DIAB1%"
--     OR conditions like "% DIAB1%";


SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '(^| )DIAB1';



-- ^ → beginning of the conditions string
-- | → OR
-- → a space before the condition
-- DIAB1 → required prefix