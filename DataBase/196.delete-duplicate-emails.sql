--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below


delete from Person 
where id not in (
    select minid from (
        select Min(id) as minId, Email 
        from Person 
        group by email
    ) as tmp
)
#Every derived table must have its own alias
-- @lc code=end

