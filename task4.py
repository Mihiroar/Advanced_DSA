import sqlite3
import csv

conn = sqlite3.connect('shipment_database.db')
cursor = conn.cursor()

with open('shipping_data_0.csv', newline='') as file:
    reader = csv.reader(file)
    for row in reader:
        # Extract relevant data from row
        # Insert data into the database using SQL INSERT statement

with open('shipping_data_1.csv', newline='') as file:
    reader = csv.reader(file)
    for row in reader:
        # Extract relevant data from row
        # Insert data into the database using SQL INSERT statement

with open('shipping_data_2.csv', newline='') as file:
    reader = csv.reader(file)
    for row in reader:
        # Extract relevant data from row
        # Combine rows based on shipping identifier
        # Determine quantity of goods in the shipment
        # Insert data into the database using SQL INSERT statement

conn.commit()
conn.close()
