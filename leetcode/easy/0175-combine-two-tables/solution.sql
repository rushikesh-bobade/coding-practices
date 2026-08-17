# Write your MySQL query statement below
SELECT firstName,lastname,city,state
from Person p
LEFT JOIN Address a
ON p.personId=a.personId;


-- SELECT 
--     p.firstName,
--     p.lastName,
--     a.city,
--     a.state
-- FROM Person AS p
-- LEFT JOIN 
-- Address AS a
-- ON p.personId=a.personId;