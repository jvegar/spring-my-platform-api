-- Personal Information
CREATE TABLE personal_info (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20),
  description TEXT,
  projects_count INTEGER
);

-- Education
CREATE TABLE education (
  id SERIAL PRIMARY KEY,
  date_range VARCHAR(20) NOT NULL,
  title VARCHAR(255) NOT NULL,
  subtitle VARCHAR(255) NOT NULL,
  order_index INTEGER
);

-- Experience
CREATE TABLE experience (
  id SERIAL PRIMARY KEY,
  date_range VARCHAR(20) NOT NULL,
  title VARCHAR(255) NOT NULL,
  company VARCHAR(255) NOT NULL,
  order_index INTEGER
);

-- Skills
CREATE TABLE skills (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  percentage INTEGER NOT NULL CHECK (percentage >= 0 AND percentage <= 100),
  last_week INTEGER,
  last_month INTEGER,
  is_main_skill BOOLEAN DEFAULT false,
  order_index INTEGER
);

-- Services
CREATE TABLE services (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL CHECK (title IN (
    'WEB DESIGN',
    'WEB DEVELOPMENT',
    'FINANCIAL ADVISORY',
    'APP DEVELOPMENT',
    'BRANDING',
    'PROCESS AUTOMATION'
  )),
  icon_path VARCHAR(255) NOT NULL,
  order_index INTEGER
);

-- Tech Stack
CREATE TABLE tech_stack (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  url VARCHAR(255) NOT NULL,
  icon_path VARCHAR(255) NOT NULL,
  order_index INTEGER
); 