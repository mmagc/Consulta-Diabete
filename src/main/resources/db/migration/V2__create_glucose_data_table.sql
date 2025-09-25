CREATE TABLE glucose_datas (
       id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
       glucose INTEGER NOT NULL,
       meassurement_time VARCHAR(100) NOT NULL,
       created_at TIMESTAMPTZ NOT NULL,
       updated_at TIMESTAMPTZ NOT NULL,
       user_id UUID NOT NULL,
       CONSTRAINT fk_glucose_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);