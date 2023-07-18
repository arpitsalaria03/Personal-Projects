#include<iostream>
#include<string.h>
#include<fstream>
using namespace std;
class car
{
    string company;
    string model;
    string id;
    long cost;
    public:
    void print();
    void fetch(string);
    void add();
    void Delete();
};
    void car::print()
    {
         cout<<"company: "<<company<<endl;
    cout<<"model: "<<model<<endl;
    cout<<"id: "<<id<<endl;
    cout<<"price "<<cost<<endl;
    }
    void car::fetch(string c_id)
    {
        string check;
        fstream open("cars.txt");
        if(open.is_open())
        {
            while(getline(open,check))
            {
                if(check==("id: "+c_id))
                {
                    getline(open,check);
                    while(check.substr(0,4)!="id: ")
                    {
                        if(check.substr(0,7)=="model: ")
                        {
                            model=check.substr(7,check.size()-7);
                        }else if(check.substr(0,7)=="price: ")
                        {
                            cost=stoi(check.substr(7,check.size()-7));
                        }else if(check.substr(0,9)=="company: ")
                        {
                            company=check.substr(9,check.size()-9);
                        }
                        if(!getline(open,check)){break;}
                    }
                    break;
                }
            }
        }
        open.close();
    }
    void car::add()
    {
        cout<<"Enter Car ID: ";
        cin>>id;
        cout<<"Enter company: ";
        cin>>company;
        cout<<"Enter car model: ";
        cin>>model;
        cout<<"Enter price: ";
        cin>>cost;
        fstream out("cars.txt", ios::app);
        if(out.is_open())
        {
            out<<"id: "<<id<<"\n";
            out<<"company: "<<company<<"\n";
            out<<"model: "<<model<<"\n";
            out<<"price: "<<cost<<"\n";
        }
        out.close();
    }
    void car::Delete()
    {
        string c_id;
        cout<<"Enter ID of the car to  be removed from database: ";
        cin>>c_id;
        string check;
    ifstream myfile;
  ofstream temp;
  myfile.open("cars.txt");
  temp.open("temp.txt");
  while (getline(myfile, check))
  {
    if (check != ("id: "+c_id))
      {temp << check << endl;}
      else if(check==("id: "+c_id))
      {
        for(int i=0;i<3;i++)
        {
            getline(myfile,check);
        }
      }
  }
  myfile.close();
  temp.close();
  remove("cars.txt");
  rename("temp.txt", "cars.txt");
    }
class customer
{
    string id;
    string name;
    long long int phone;
    string address;
    string p_id;
    public:
    void print();
    void fetch(string);
    void add(string);
    void Delete(string);
};
void customer::print()
{
     cout<<"id: "<<id<<endl;
    cout<<"name: "<<name<<endl;
    cout<<"phone: "<<phone<<endl;
    cout<<"address: "<<address<<endl;
    cout<<"payment id: "<<p_id<<endl;
}
void customer::fetch(string c_id)
{
    string check;
        fstream open("customers.txt");
        if(open.is_open())
        {
            while(getline(open,check))
            {
                if(check==("id: "+c_id))
                {
                    getline(open,check);
                    while(check.substr(0,4)!="id: ")
                    {
                        if(check.substr(0,6)=="name: ")
                        {
                            name=check.substr(6,check.size()-6);
                        }else if(check.substr(0,7)=="phone: ")
                        {
                            phone=stoi(check.substr(7,check.size()-7));
                        }else if(check.substr(0,9)=="address: ")
                        {
                            address=check.substr(9,check.size()-9);
                        }
                        else if(check.substr(0,12)=="payment_id: ")
                        {
                            p_id=check.substr(12,check.size()-12);
                        }
                        if(!getline(open,check)){break;}
                    }
                    break;
                }
            }
        }
        open.close();
}
void customer::add(string pay_id)
{
     cout<<"Enter Customer ID: ";
        cin>>id;
        cout<<"Enter customer name: ";
        cin>>name;
        cout<<"Enter customer phone number: ";
        cin>>phone;
        cout<<"Enter customer address: ";
        cin>>address;
        fstream out("customers.txt", ios::app);
        if(out.is_open())
        {
            out<<"id: "<<id<<"\n";
            out<<"name: "<<name<<"\n";
            out<<"phone: "<<phone<<"\n";
            out<<"address: "<<address<<"\n";
            out<<"payment_id: "<<pay_id<<"\n";
        }
        out.close();
}
void customer::Delete(string c_id)
{
        string check;
    ifstream myfile;
  ofstream temp;
  myfile.open("customers.txt");
  temp.open("temp.txt");
  while (getline(myfile, check))
  {
    if (check != ("id: "+c_id))
      {temp << check << endl;}
      else if(check==("id: "+c_id))
      {
        for(int i=0;i<4;i++)
        {
            getline(myfile,check);
        }
      }
  }
  myfile.close();
  temp.close();
  remove("customers.txt");
  rename("temp.txt", "customers.txt");
}
class employee
{
    string id;
    string name;
    long long int phone;
    string address;
    int salary;
    public:
    void print();
    void add();
    void fetch(string);
    void Delete(string);
};
void employee::print()
{
    cout<<"id: "<<id<<endl;
    cout<<"name: "<<name<<endl;
    cout<<"phone: "<<phone<<endl;
    cout<<"address: "<<address<<endl;
    cout<<"salary: "<<salary<<endl;
}
void employee::add()
{
     cout<<"Enter Employee ID: ";
        cin>>id;
        cout<<"Enter Employee name: ";
        cin>>name;
        cout<<"Enter Employee phone number: ";
        cin>>phone;
        cout<<"Enter Employee address: ";
        cin>>address;
        cout<<"Enter Employee Salary: ";
        cin>>salary;
        fstream out("employees.txt", ios::app);
        if(out.is_open())
        {
            out<<"id: "<<id<<"\n";
            out<<"name: "<<name<<"\n";
            out<<"phone: "<<phone<<"\n";
            out<<"address: "<<address<<"\n";
            out<<"salary: "<<salary<<"\n";
        }
        out.close();
}
void employee::fetch(string c_id)
{
    string check;
        fstream open("employees.txt");
        if(open.is_open())
        {
            while(getline(open,check))
            {
                if(check==("id: "+c_id))
                {
                    getline(open,check);
                    while(check.substr(0,4)!="id: ")
                    {
                        if(check.substr(0,6)=="name: ")
                        {
                            name=check.substr(6,check.size()-6);
                        }else if(check.substr(0,7)=="phone: ")
                        {
                            phone=stoi(check.substr(7,check.size()-7));
                        }else if(check.substr(0,9)=="address: ")
                        {
                            address=check.substr(9,check.size()-9);
                        }
                        else if(check.substr(0,8)=="salary: ")
                        {
                            salary=stoi(check.substr(8,check.size()-8));
                        }
                        if(!getline(open,check)){break;}
                    }
                    break;
                }
            }
        }
        open.close();
}
void employee::Delete(string c_id)
{
        string check;
    ifstream myfile;
  ofstream temp;
  myfile.open("employees.txt");
  temp.open("temp.txt");
  while (getline(myfile, check))
  {
    if (check != ("id: "+c_id))
      {temp << check << endl;}
      else if(check==("id: "+c_id))
      {
        for(int i=0;i<4;i++)
        {
            getline(myfile,check);
        }
      }
  }
  myfile.close();
  temp.close();
  remove("employees.txt");
  rename("temp.txt", "employees.txt");
}
class payment
{
    string id;
    string type;
    string date;
    string customer_id;
    public:
    void print();
    string add();
    void fetch(string);
    void Delete(string);
};
void payment::print()
{
    cout<<"id: "<<id<<endl;
    cout<<"type: "<<type<<endl;
    cout<<"date: "<<date<<endl;
    cout<<"customer id: "<<customer_id<<endl;
}
string payment::add()
{
    cout<<"Enter payment ID: ";
        cin>>id;
        cout<<"Enter payment type: ";
        cin>>type;
        cout<<"Enter payment date: ";
        cin>>date;
        cout<<"Enter customer id: ";
        cin>>customer_id;
        fstream out("payments.txt", ios::app);
        if(out.is_open())
        {
            out<<"id: "<<id<<"\n";
            out<<"type: "<<type<<"\n";
            out<<"date: "<<date<<"\n";
            out<<"customer_id: "<<customer_id<<"\n";
        }
        out.close();
        return id;
}
void payment::fetch(string c_id)
{
    string check;
        fstream open("payments.txt");
        if(open.is_open())
        {
            while(getline(open,check))
            {
                if(check==("id: "+c_id))
                {
                    getline(open,check);
                    while(check.substr(0,4)!="id: ")
                    {
                        if(check.substr(0,6)=="type: ")
                        {
                            type=check.substr(6,check.size()-6);
                        }else if(check.substr(0,6)=="date: ")
                        {
                            date=stoi(check.substr(6,check.size()-6));
                        }else if(check.substr(0,13)=="customer_id: ")
                        {
                            customer_id=check.substr(13,check.size()-13);
                        }
                        if(!getline(open,check)){break;}
                    }
                    break;
                }
            }
        }
        open.close();
}
void payment::Delete(string c_id)
{
        string check;
    ifstream myfile;
  ofstream temp;
  myfile.open("payments.txt");
  temp.open("temp.txt");
  while (getline(myfile, check))
  {
    if (check != ("id: "+c_id))
      {temp << check << endl;}
      else if(check==("id: "+c_id))
      {
        for(int i=0;i<3;i++)
        {
            getline(myfile,check);
        }
      }
  }
  myfile.close();
  temp.close();
  remove("payments.txt");
  rename("temp.txt", "payments.txt");
}
void print_cars()
{
    string fetch;
    fstream display("cars.txt");
    while(getline(display,fetch))
    {
        cout<<fetch<<endl;
    }
}
void print_customers()
{
     string fetch;
    fstream display("customers.txt");
    while(getline(display,fetch))
    {
        cout<<fetch<<endl;
    }
}
void print_payments()
{
     string fetch;
    fstream display("payments.txt");
    while(getline(display,fetch))
    {
        cout<<fetch<<endl;
    }
}
void print_employees()
{
    
     string fetch;
    fstream display("employees.txt");
    while(getline(display,fetch))
    {
        cout<<fetch<<endl;
    }

}
void instructions()
{
    cout<<endl<<endl<<"---------------------------INSTRUCTIONS------------------------------";
     cout<<"\nOption 1: Manage Employees Data";
        cout<<"\nOption 2: Manage Customers Data";
        cout<<"\nOption 3: Manage Cars Collection Data";
        cout<<"\nOption 4: Manage Transactions Data";
        cout<<"\nOption 5: Sell a Car";
        cout<<"\nOption 6: Exit";
}
void sell()
{
    cout<<"AVAILABLE CARS:----------------------------------------------------------------"<<endl;
    print_cars();
    cout<<"Enter id of chosen car: ";
    string c_id;
    cin>>c_id;
    payment p;
    string pay_id=p.add();
    customer c;
    c.add(pay_id);
    cout<<"CAR PURCHASED SUCCESSFULLY-------------------------------------------------------"<<endl<<endl;
}
void emp_data()
{
    int ch;
    employee emp;
    cout<<"1. Print all employee data"<<endl;
    cout<<"2. Print unique employee data"<<endl;
    cout<<"3. Add Employee"<<endl;
    cout<<"4. Delete unique employee data"<<endl;
    cout<<"5. Exit"<<endl;
    while(true)
    {
        cout<<"Enter choice: ";
        cin>>ch;
        if(ch==1)
        {
            print_employees();
            cout<<endl;
        }else if(ch==2)
        {
            string id;
            cout<<"Enter employee id: ";
            cin>>id;
            emp.fetch(id);
            emp.print();
            cout<<endl;
        }else if(ch==3)
        {
           emp.add();
           cout<<"Record Added Successfully------------------------------"<<endl;
        }else if(ch==4)
        {
             string id;
            cout<<"Enter employee id: ";
            cin>>id;
            emp.Delete(id);
            cout<<"Record Deleted Successfully------------------------------"<<endl;
        }else if(ch==5)
        {
             cout<<"--------------------------------------------------------------------------"<<endl<<endl;
            break;
        }
    }
}
void pay_data()
{
    int ch;
    payment pay;
    cout<<"1. Print all transactions"<<endl;
    cout<<"2. Print unique transaction"<<endl;
    cout<<"3. Add Transaction"<<endl;
    cout<<"4. Delete unique Transaction"<<endl;
    cout<<"5. Exit"<<endl;
    while(true)
    {
        cout<<"Enter choice: ";
        cin>>ch;
        if(ch==1)
        {
            print_payments();
            cout<<endl;
        }else if(ch==2)
        {
            string id;
            cout<<"Enter payment id: ";
            cin>>id;
            pay.fetch(id);
            pay.print();
            cout<<endl;
        }else if(ch==3)
        {
           pay.add();
           cout<<"Record Added Successfully------------"<<endl;
        }else if(ch==4)
        {
             string id;
            cout<<"Enter payment id: ";
            cin>>id;
            pay.Delete(id);
            cout<<"Record Deleted Successfully-------------"<<endl;
        }else if(ch==5)
        {
            cout<<"--------------------------------------------------------------------------"<<endl<<endl;
            break;
        }
    }
}
void cust_data()
{
    int ch;
    customer cust;
    cout<<"1. Print all customers data"<<endl;
    cout<<"2. Print unique customer data"<<endl;
    cout<<"3. Add customer"<<endl;
    cout<<"4. Delete unique customer"<<endl;
    cout<<"5. Exit"<<endl;
    while(true)
    {
        cout<<"Enter choice: ";
        cin>>ch;
        if(ch==1)
        {
            print_customers();
            cout<<endl;
        }else if(ch==2)
        {
            string id;
            cout<<"Enter customer id: ";
            cin>>id;
            cust.fetch(id);
            cust.print();
            cout<<endl;
        }else if(ch==3)
        {
             string id;
            cout<<"Enter payment id: ";
            cin>>id;
           cust.add(id);
            cout<<"Record Added Successfully-------------"<<endl<<endl;
        }else if(ch==4)
        {
             string id;
            cout<<"Enter customer id: ";
            cin>>id;
            cust.Delete(id);
            cout<<"Record Deleted Successfully-------------"<<endl<<endl;
        }else if(ch==5)
        {
             cout<<"--------------------------------------------------------------------------"<<endl<<endl;
            break;
        }
    }
}
void car_data()
{
    int ch;
    car c;
    cout<<"1. Print all cars data"<<endl;
    cout<<"2. Print unique car data"<<endl;
    cout<<"3. Add car"<<endl;
    cout<<"4. Delete unique car"<<endl;
    cout<<"5. Exit"<<endl;
    while(true)
    {
        cout<<"Enter choice: ";
        cin>>ch;
        if(ch==1)
        {
            print_cars();
            cout<<endl;
        }else if(ch==2)
        {
            string id;
            cout<<"Enter car id: ";
            cin>>id;
            c.fetch(id);
            c.print();
            cout<<endl;
        }else if(ch==3)
        {
           c.add();
           cout<<"Record Added Successfully--------------------------"<<endl;
        }else if(ch==4)
        {
            c.Delete();
            cout<<"Record Deleted Successfully--------------------------"<<endl;
        }else if(ch==5)
        {
            cout<<"--------------------------------------------------------------------------"<<endl<<endl;
            break;
        }
    }
}
int main()
{
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<"_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++";
    cout<<endl;
    cout<<"                       WELCOME TO ITSOURCECODE CAR SALES MANAGEMENT SYSTEM                      ";
    cout<<endl<<"_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++_++";
    int choice;
    while(true)
    {
        instructions();
        cout<<endl<<"Enter Choice: ";
    cin>>choice;
    cout<<endl;
    switch(choice)
    {
        case 1:
        emp_data();
        break;

        case 2:
        cust_data();
        break;

        case 3:
        car_data();
        break;

        case 4:
        pay_data();
        break;

        case 5:
        sell();
        break;

        case 6:
        cout<<"---------------------------------END----------------------------------"<<endl;
        goto state;
        break;
        
        default:
        break;
    }
    }
    state: return 0;
}