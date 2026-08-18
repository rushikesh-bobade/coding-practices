# Write your MySQL query statement below
SELECT user_id, name, mail
FROM Users
WHERE REGEXP_LIKE(
    mail,
    '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$',
    'c'
);

-- How the pattern works
-- ^ → start of email
-- [A-Za-z] → first character must be a letter
-- [A-Za-z0-9_.-]* → remaining prefix can contain letters, digits, _, ., -
-- @leetcode\\.com → must end with exactly @leetcode.com
-- $ → end of email