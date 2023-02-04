CREATE TABLE IF NOT EXISTS person (
  id uuid PRIMARY KEY,
  name text NOT NULL,
  cpf text NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS message (
  id uuid PRIMARY KEY,
  message text NOT NULL,
  receiver_id uuid NOT NULL REFERENCES person(id),
  sender_id uuid NOT NULL REFERENCES person(id),
  send_date timestamp NOT NULL
);
