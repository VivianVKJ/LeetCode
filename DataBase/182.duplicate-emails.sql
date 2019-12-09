--
-- @lc app=leetcode id=182 lang=mysql
--
-- [182] Duplicate Emails
--

-- @lc code=start

-- select email from (
--     select Email, count(Email) Times
--     from person 
--     group by Email
-- ) Count
-- where Count.times > 1

select Email 
from person
group by email
having count(*) >1;

-- @lc code=end

