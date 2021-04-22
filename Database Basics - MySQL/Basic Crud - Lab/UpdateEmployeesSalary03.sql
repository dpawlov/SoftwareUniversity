/*Problem 3: Update Employees Salary*/
SET SQL_SAFE_UPDATES = 0;

UPDATE `employees`
SET `salary` = `salary` * 1200
WHERE `job_title` = 'Manager';

SELECT `salary` 
FROM `employees`
ORDER BY `salary` ASC;