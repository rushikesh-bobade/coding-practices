# Write your MySQL query statement below
select name as Customers
from Customers s
left join Orders o
    On s.id=o.customerId
where o.customerId IS NULL;