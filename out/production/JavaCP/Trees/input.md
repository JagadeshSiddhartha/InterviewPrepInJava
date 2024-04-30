##Snapshot
Features | Details
--- | ---
Release Status | Released
Source API Version | v2
Table Selection | Yes
Column Selection | Yes
Edit Integration | Yes
Replication Type Selection | No
Authentication Parameters | zoho account email<br>Passoword
Replication Type | Key Based Replication
Replication Key | Modified_Time
Suggested Replication Frequency | 24 hrs

Tables/APIs Supported |
--- | ---
Quotes | Solutions 
 Vendors | Cases 
 Campaigns | Products 
 Leads | Accounts 
 Contacts | Deals 
 Tasks | Events 
 Calls | Price_Books 
 Sales_Orders | Purchase_Orders 
 Invoices | Notes 
 Activities

##Integrate ZohoCRM with Daton
1. Signin to Daton 
2. Select ZohoCRM from Integrations page
3. Provide Integration Name, Replication Frequency, and History. Integration name would be used in creating tables for the integration and cannot be changed later 
4. Provide Zoho Account Email and Password to authorize Daton to periodically extract data from ZohoCRM
5. Post successful authentication, you will be prompted to choose from the list of available tables
6. Then select all required fields for each table
7. Submit the integration
		
##Workflow
1. Integrations would be in Pending state initially and will be moved to Active state as soon as the first job loads data successfully on to the configured warehouse
2. Users would be able to edit/pause/re-activate/delete integration anytime
3. Users can view job status and process logs from the integration details page by clicking on the integration name from the active list
		
##ZohoCRM Data
####Quotes
Purpose: Sales Quotes are legally binding agreements between a customer and vendor to deliver the customer requested products in a specified time-frame at a predefined price.


Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/quotes-response.html

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Discount | NUMERIC
Description | STRING
currency_symbol | STRING
Shipping_State | STRING
Tax | NUMERIC
Modified_By | RECORD
converted | BOOLEAN
process_flow | BOOLEAN
Deal_Name | STRING
Valid_Till | STRING
Billing_Country | STRING
Team | STRING
Account_Name | RECORD
id | STRING
Carrier | STRING
approved | BOOLEAN
Quote_Stage | STRING
Grand_Total | NUMERIC
approval | RECORD
Modified_Time | STRING
Billing_Street | STRING
Adjustment | NUMERIC
Created_Time | STRING
Terms_and_Conditions | STRING
Sub_Total | NUMERIC
editable | BOOLEAN
Billing_Code | STRING
Product_Details | RECORD
Subject | STRING
Contact_Name | RECORD
Shipping_City | STRING
Shipping_Country | STRING
Shipping_Code | STRING
Billing_City | STRING
Quote_Number | STRING
Billing_State | STRING
line_tax | RECORD
Created_By | RECORD
Tag | STRING
Shipping_Street | STRING


####Solutions
Purpose:  Set of solutions that will guide you in creating reports for widely asked Key Sales Performance metrics over the Zoho CRM data

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/solutions-response.html

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Status | STRING
approval | RECORD
Owner | RECORD
Modified_Time | STRING
currency_symbol | STRING
Created_Time | STRING
Comments | STRING
No_of_comments | NUMERIC
Product_Name | STRING
editable | BOOLEAN
Add_Comment | STRING
Solution_Number | STRING
Answer | STRING
Modified_By | RECORD
process_flow | BOOLEAN
Solution_Title | STRING
Question | STRING
id | STRING
Created_By | RECORD
Tag | STRING
approved | BOOLEAN


####Vendors	
Purpose: Vendors include companies, people, and contractors from which your company gets products and services. They can be either direct manufacturers or resellers. 

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/vendors-response.html

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Email | STRING
Category | STRING
Description | STRING
currency_symbol | STRING
Vendor_Name | STRING
Website | STRING
Record_Image | STRING
Modified_By | RECORD
process_flow | BOOLEAN
Phone | STRING
Street | STRING
Zip_Code | STRING
id | STRING
approved | BOOLEAN
approval | RECORD
Modified_Time | STRING
Created_Time | STRING
editable | BOOLEAN
City | STRING
State | STRING
GL_Account | STRING
Country | STRING
Created_By | RECORD
Tag | STRING


####Cases
Purpose: In general, case trouble tickets are used to capture customer feedback on various types of issues that arise after purchasing a product or service from your company.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/cases-respones.html 

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Email | STRING
Description | STRING
currency_symbol | STRING
Internal_Comments | STRING
No_of_comments | NUMERIC
Reported_By | STRING
Case_Number | STRING
Modified_By | RECORD
process_flow | BOOLEAN
Deal_Name | RECORD
Phone | STRING
Account_Name | RECORD
id | STRING
approved | BOOLEAN
Solution | STRING
Status | STRING
approval | RECORD
Modified_Time | STRING
Priority | STRING
Created_Time | STRING
Comments | STRING
Product_Name | RECORD
editable | BOOLEAN
Add_Comment | STRING
Case_Origin | STRING
Case_Reason | STRING
Subject | STRING
Type | STRING
Tag | STRING
Created_By | RECORD
Related_To | RECORD


####Campaigns	
Purpose: campaign management helps you to plan, execute and monitor campaigns in an organized way. You can do the followin

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/campaigns-respones.html

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Status | STRING
approval | RECORD
Owner | RECORD
Modified_Time | STRING
Description | STRING
currency_symbol | STRING
Campaign_Name | STRING
Created_Time | STRING
editable | BOOLEAN
End_Date | STRING
Type | STRING
Modified_By | RECORD
Num_sent | STRING
process_flow | BOOLEAN
Expected_Revenue | NUMERIC
Actual_Cost | NUMERIC
id | STRING
Expected_Response | STRING
Created_By | RECORD
Tag | STRING
Parent_Campaign | STRING
Start_Date | STRING
approved | BOOLEAN
Budgeted_Cost | NUMERIC


####Products
Purpose: Products can be either goods or services, which are sold or procured by your organization

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/products-respones.html

Replication: Key-Based Replication

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Product_Category | STRING
Qty_in_Demand | NUMERIC
Owner | RECORD
Description | STRING
currency_symbol | STRING
Vendor_Name | RECORD
Sales_Start_Date | STRING
Tax | STRING
Product_Active | BOOLEAN
Record_Image | STRING
Modified_By | RECORD
Product_Code | STRING
process_flow | BOOLEAN
Manufacturer | STRING
id | STRING
Support_Expiry_Date | STRING
approved | BOOLEAN
approval | RECORD
Modified_Time | STRING
Created_Time | STRING
Commission_Rate | NUMERIC
Product_Name | STRING
Handler | STRING
editable | BOOLEAN
Support_Start_Date | STRING
Usage_Unit | STRING
Qty_Ordered | NUMERIC
Qty_in_Stock | NUMERIC
Created_By | RECORD
Tag | STRING
Sales_End_Date | STRING
Unit_Price | NUMERIC
Taxable | BOOLEAN
Reorder_Level | NUMERIC


####Leads
Purpose: Leads are the details gathered about an individual or representatives of an organization

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/leads-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Company | STRING
Email | STRING
Description | STRING
currency_symbol | STRING
Rating | STRING
Website | STRING
Twitter | STRING
Salutation | STRING
Last_Activity_Time | STRING
First_Name | STRING
Full_Name | STRING
Lead_Status | STRING
Industry | STRING
Record_Image | STRING
Modified_By | RECORD
Skype_ID | STRING
converted | BOOLEAN
process_flow | BOOLEAN
Phone | STRING
Street | STRING
Zip_Code | STRING
id | STRING
Email_Opt_Out | BOOLEAN
approved | BOOLEAN
Designation | STRING
approval | RECORD
Modified_Time | STRING
Created_Time | STRING
editable | BOOLEAN
City | STRING
No_of_Employees | NUMERIC
Mobile | STRING
Last_Name | STRING
State | STRING
Lead_Source | STRING
Country | STRING
Tag | STRING
Created_By | RECORD
Fax | STRING
Annual_Revenue | NUMERIC
Secondary_Email | STRING


####Accounts
Purpose:  Account represents a Company or a Department within the company, with which your organization is currently doing business with or is planning to do business with in the future

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/accounts-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Ownership | STRING
Description | STRING
currency_symbol | STRING
Account_Type | STRING
Rating | STRING
SIC_Code | NUMERIC
Shipping_State | STRING
Website | STRING
Employees | NUMERIC
Last_Activity_Time | STRING
Industry | STRING
Record_Image | STRING
Modified_By | RECORD
Account_Site | STRING
process_flow | BOOLEAN
Phone | STRING
Billing_Country | STRING
Account_Name | STRING
id | STRING
Account_Number | STRING
approved | BOOLEAN
Ticker_Symbol | STRING
approval | RECORD
Modified_Time | STRING
Billing_Street | STRING
Created_Time | STRING
editable | BOOLEAN
Billing_Code | STRING
Parent_Account | STRING
Shipping_City | STRING
Shipping_Country | STRING
Shipping_Code | STRING
Billing_City | STRING
Billing_State | STRING
Tag | STRING
Created_By | RECORD
Fax | STRING
Annual_Revenue | NUMERIC
Shipping_Street | STRING


####Contacts
Purpose: Contacts are people with whom you communicate, either in pursuit of a business opportunity or for personal reasons

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/contacts-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Email | STRING
Description | STRING
currency_symbol | STRING
Vendor_Name | STRING
Mailing_Zip | STRING
Other_Phone | STRING
Mailing_State | STRING
Twitter | STRING
Other_Zip | STRING
Mailing_Street | STRING
Other_State | STRING
Salutation | STRING
Other_Country | STRING
Last_Activity_Time | STRING
First_Name | STRING
Full_Name | STRING
Asst_Phone | STRING
Record_Image | STRING
Department | STRING
Modified_By | RECORD
Skype_ID | STRING
process_flow | BOOLEAN
Assistant | STRING
Phone | STRING
Mailing_Country | STRING
Account_Name | STRING
id | STRING
Email_Opt_Out | BOOLEAN
approved | BOOLEAN
Reporting_To | STRING
approval | RECORD
Modified_Time | STRING
Date_of_Birth | STRING
Mailing_City | STRING
Other_City | STRING
Created_Time | STRING
Title | STRING
editable | BOOLEAN
Other_Street | STRING
Mobile | STRING
Home_Phone | STRING
Last_Name | STRING
Lead_Source | STRING
Tag | STRING
Created_By | RECORD
Fax | STRING
Secondary_Email | STRING

####Tasks
Purpose: A task is a specific piece of work that is usually time bound. In Zoho CRM, tasks are listed in the record's Home page, Activities home page, and in other related records.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/tasks-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Status | STRING
approval | RECORD
Owner | RECORD
Modified_Time | STRING
Description | STRING
currency_symbol | STRING
Due_Date | STRING
Priority | STRING
Created_Time | STRING
Closed_Time | STRING
editable | BOOLEAN
Subject | STRING
Send_Notification_Email | BOOLEAN
se_module | STRING
Modified_By | RECORD
Recurring_Activity | STRING
process_flow | BOOLEAN
What_Id | RECORD
id | STRING
Created_By | RECORD
Tag | STRING
approved | BOOLEAN
Remind_At | STRING
Who_Id | RECORD


####Events
Purpose: An event is an activity that happens at a given place and time. They are listed in the Zoho CRM's Home page of the user, Activities home page, Calendar and in other related records.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/events-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
All_day | BOOLEAN
Owner | RECORD
Check_In_State | STRING
Check_In_Address | STRING
Description | STRING
currency_symbol | STRING
Start_DateTime | STRING
Latitude | STRING
Participants | STRING
Event_Title | STRING
calendar_booking_event | BOOLEAN
End_DateTime | STRING
Check_In_By | STRING
Modified_By | RECORD
process_flow | BOOLEAN
Check_In_City | STRING
id | STRING
Check_In_Comment | STRING
approved | BOOLEAN
Remind_At | STRING
Who_Id | STRING
Check_In_Status | STRING
Check_In_Country | STRING
approval | RECORD
Modified_Time | STRING
Venue | STRING
ZIP_Code | STRING
Created_Time | STRING
editable | BOOLEAN
recurrence_id | STRING
Longitude | STRING
Check_In_Time | STRING
se_module | STRING
Recurring_Activity | STRING
What_Id | RECORD
Check_In_Sub_Locality | STRING
u_id | STRING
Created_By | RECORD
Tag | STRING
send_notification | BOOLEAN


####Calls
Purpose:automatically log all call activities, texts, call recordings and voicemails under your contacts

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/calls-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Call_Duration | STRING
Owner | RECORD
Description | STRING
currency_symbol | STRING
calendar_booking_call | BOOLEAN
Modified_By | RECORD
process_flow | BOOLEAN
Call_Purpose | STRING
id | STRING
Call_Status | STRING
approved | BOOLEAN
Who_Id | STRING
approval | RECORD
Modified_Time | STRING
Reminder | STRING
Created_Time | STRING
Call_Start_Time | STRING
Billable | BOOLEAN
editable | BOOLEAN
Subject | STRING
se_module | STRING
Call_Type | STRING
Call_Result | STRING
What_Id | RECORD
Call_Duration_in_seconds | STRING
Created_By | RECORD
Tag | STRING

####Price_Books
Purpose: Price Books are used for selling products at different prices, based on the agreement terms with a particular type of customer.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/price-books-respones.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
approval | RECORD
Owner | RECORD
Modified_Time | STRING
Pricing_Details | STRING
Description | STRING
currency_symbol | STRING
Created_Time | STRING
editable | BOOLEAN
Active | BOOLEAN
Modified_By | RECORD
Pricing_Model | STRING
process_flow | BOOLEAN
Price_Book_Name | STRING
id | STRING
Created_By | RECORD
Tag | STRING
approved | BOOLEAN



####Purchase_Orders
Purpose: A Purchase Order is an order placed for procuring products or services from your vendors.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/purchase-orders-response.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Discount | NUMERIC
Description | STRING
currency_symbol | STRING
Vendor_Name | RECORD
Shipping_State | STRING
Tax | NUMERIC
PO_Date | STRING
Modified_By | RECORD
process_flow | BOOLEAN
Billing_Country | STRING
id | STRING
Carrier | STRING
approved | BOOLEAN
Status | STRING
Sales_Commission | NUMERIC
Grand_Total | NUMERIC
approval | RECORD
Modified_Time | STRING
PO_Number | STRING
Due_Date | STRING
Billing_Street | STRING
Adjustment | NUMERIC
Created_Time | STRING
Terms_and_Conditions | STRING
Sub_Total | NUMERIC
editable | BOOLEAN
Billing_Code | STRING
Product_Details | RECORD
Subject | STRING
Tracking_Number | STRING
Contact_Name | RECORD
Excise_Duty | NUMERIC
Shipping_City | STRING
Shipping_Country | STRING
Shipping_Code | STRING
Billing_City | STRING
Requisition_No | STRING
Billing_State | STRING
line_tax | RECORD
Created_By | RECORD
Tag | STRING
Shipping_Street | STRING


####Notes
Purpose: In Zoho CRM, you can associate notes to the records by specifying the required detail

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/notes-response.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
Owner | RECORD
Owner | RECORD
Modified_Time | STRING
attachments | STRING
Created_Time | STRING
Parent_Id | RECORD
editable | BOOLEAN
se_module | STRING
Modified_By | RECORD
size | STRING
voice_note | BOOLEAN
id | STRING
Created_By | RECORD
Note_Title | STRING
Note_Content | STRING


####Activities
Purpose:  An important aspect in CRM is to keep track of all the tasks, meetings, calls, events, or activity records.

Source API Documentation <Link> https://www.zoho.com/crm/help/developer/api/activities-response.html

Replication: Key-Based Replication	

Replication Key: Modified_Time

#####Fields
Name | Target Datatype
--- | ---
All_day | STRING
Check_In_State | STRING
Owner | RECORD
currency_symbol | STRING
Latitude | STRING
Participants | STRING
process_flow | BOOLEAN
Check_In_City | STRING
Call_Purpose | STRING
id | STRING
Check_In_Comment | STRING
approved | BOOLEAN
Check_In_Status | STRING
Who_Id | STRING
Status | STRING
approval | RECORD
Venue | STRING
ZIP_Code | STRING
Activity_Type | STRING
Priority | STRING
Created_Time | STRING
Call_Start_Time | STRING
editable | BOOLEAN
Longitude | STRING
Check_In_Time | STRING
Call_Result | STRING
Recurring_Activity | STRING
What_Id | RECORD
Created_By | RECORD
Call_Duration | STRING
Check_In_Address | STRING
Description | STRING
Closed_Time | STRING
Start_DateTime | STRING
End_DateTime | STRING
Check_In_By | STRING
Modified_By | RECORD
Call_Status | STRING
Check_In_Country | STRING
Modified_Time | STRING
Reminder | STRING
Due_Date | STRING
Billable | BOOLEAN
Subject | STRING
se_module | STRING
Call_Type | STRING
Check_In_Sub_Locality | STRING
Call_Duration_in_seconds | STRING
Tag | STRING