--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-05 11:34:56 EST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Restaurant";
--
-- TOC entry 3352 (class 1262 OID 16435)
-- Name: Restaurant; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Restaurant" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';


ALTER DATABASE "Restaurant" OWNER TO "postgres";

\connect "Restaurant"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "public";


ALTER SCHEMA "public" OWNER TO "postgres";

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA "public"; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA "public" IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = "heap";

--
-- TOC entry 207 (class 1259 OID 16471)
-- Name: Dishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Dishes" (
    "id" integer NOT NULL,
    "name" character varying(250) NOT NULL
);


ALTER TABLE "public"."Dishes" OWNER TO "postgres";

--
-- TOC entry 206 (class 1259 OID 16469)
-- Name: Dishes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Dishes_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Dishes_id_seq" OWNER TO "postgres";

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 206
-- Name: Dishes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Dishes_id_seq" OWNED BY "public"."Dishes"."id";


--
-- TOC entry 201 (class 1259 OID 16438)
-- Name: Ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Ingredients" (
    "id" integer NOT NULL,
    "name" character varying(250) NOT NULL,
    "stock" numeric,
    "organic" boolean,
    "calories" numeric,
    "vegan" boolean,
    "shelfLife" numeric
);


ALTER TABLE "public"."Ingredients" OWNER TO "postgres";

--
-- TOC entry 200 (class 1259 OID 16436)
-- Name: Ingredients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Ingredients_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Ingredients_id_seq" OWNER TO "postgres";

--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 200
-- Name: Ingredients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Ingredients_id_seq" OWNED BY "public"."Ingredients"."id";


--
-- TOC entry 215 (class 1259 OID 16512)
-- Name: MenuDishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."MenuDishes" (
    "menuId" integer NOT NULL,
    "dishId" integer NOT NULL,
    "price" numeric NOT NULL
);


ALTER TABLE "public"."MenuDishes" OWNER TO "postgres";

--
-- TOC entry 203 (class 1259 OID 16449)
-- Name: Menus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Menus" (
    "id" integer NOT NULL,
    "name" character varying NOT NULL,
    "startTime" time with time zone,
    "endTime" time with time zone
);


ALTER TABLE "public"."Menus" OWNER TO "postgres";

--
-- TOC entry 202 (class 1259 OID 16447)
-- Name: Menus_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Menus_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Menus_id_seq" OWNER TO "postgres";

--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 202
-- Name: Menus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Menus_id_seq" OWNED BY "public"."Menus"."id";


--
-- TOC entry 217 (class 1259 OID 16528)
-- Name: OrderDishes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."OrderDishes" (
    "orderId" integer NOT NULL,
    "dishId" integer NOT NULL,
    "menuId" integer NOT NULL,
    "quantity" numeric NOT NULL
);


ALTER TABLE "public"."OrderDishes" OWNER TO "postgres";

--
-- TOC entry 213 (class 1259 OID 16498)
-- Name: Orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Orders" (
    "id" integer NOT NULL,
    "tabletopId" integer NOT NULL
);


ALTER TABLE "public"."Orders" OWNER TO "postgres";

--
-- TOC entry 212 (class 1259 OID 16496)
-- Name: Orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Orders_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Orders_id_seq" OWNER TO "postgres";

--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 212
-- Name: Orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Orders_id_seq" OWNED BY "public"."Orders"."id";


--
-- TOC entry 214 (class 1259 OID 16504)
-- Name: RecipeIngredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."RecipeIngredients" (
    "recipeId" integer NOT NULL,
    "ingredientId" integer NOT NULL,
    "quantity" numeric NOT NULL,
    "unit" character varying NOT NULL
);


ALTER TABLE "public"."RecipeIngredients" OWNER TO "postgres";

--
-- TOC entry 205 (class 1259 OID 16460)
-- Name: Recipes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Recipes" (
    "id" integer NOT NULL,
    "dishId" integer NOT NULL,
    "name" character varying NOT NULL,
    "instructions" "text",
    "prepTime" numeric
);


ALTER TABLE "public"."Recipes" OWNER TO "postgres";

--
-- TOC entry 204 (class 1259 OID 16458)
-- Name: Recipes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Recipes_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Recipes_id_seq" OWNER TO "postgres";

--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 204
-- Name: Recipes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Recipes_id_seq" OWNED BY "public"."Recipes"."id";


--
-- TOC entry 216 (class 1259 OID 16520)
-- Name: SupplierIngredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."SupplierIngredients" (
    "supplierId" integer NOT NULL,
    "ingredientId" integer NOT NULL,
    "qtyAvailable" numeric,
    "units" character varying,
    "unitCost" numeric NOT NULL
);


ALTER TABLE "public"."SupplierIngredients" OWNER TO "postgres";

--
-- TOC entry 209 (class 1259 OID 16479)
-- Name: Suppliers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Suppliers" (
    "id" integer NOT NULL,
    "name" character varying(250) NOT NULL,
    "address" character varying(500),
    "email" character varying(250)
);


ALTER TABLE "public"."Suppliers" OWNER TO "postgres";

--
-- TOC entry 208 (class 1259 OID 16477)
-- Name: Suppliers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Suppliers_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Suppliers_id_seq" OWNER TO "postgres";

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 208
-- Name: Suppliers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Suppliers_id_seq" OWNED BY "public"."Suppliers"."id";


--
-- TOC entry 211 (class 1259 OID 16490)
-- Name: Tabletops; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "public"."Tabletops" (
    "id" integer NOT NULL,
    "seatCount" smallint
);


ALTER TABLE "public"."Tabletops" OWNER TO "postgres";

--
-- TOC entry 210 (class 1259 OID 16488)
-- Name: Tabletops_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "public"."Tabletops_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "public"."Tabletops_id_seq" OWNER TO "postgres";

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 210
-- Name: Tabletops_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "public"."Tabletops_id_seq" OWNED BY "public"."Tabletops"."id";


--
-- TOC entry 3180 (class 2604 OID 16474)
-- Name: Dishes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Dishes" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Dishes_id_seq"'::"regclass");


--
-- TOC entry 3177 (class 2604 OID 16441)
-- Name: Ingredients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Ingredients" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Ingredients_id_seq"'::"regclass");


--
-- TOC entry 3178 (class 2604 OID 16452)
-- Name: Menus id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Menus" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Menus_id_seq"'::"regclass");


--
-- TOC entry 3183 (class 2604 OID 16501)
-- Name: Orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Orders_id_seq"'::"regclass");


--
-- TOC entry 3179 (class 2604 OID 16463)
-- Name: Recipes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Recipes_id_seq"'::"regclass");


--
-- TOC entry 3181 (class 2604 OID 16482)
-- Name: Suppliers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Suppliers" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Suppliers_id_seq"'::"regclass");


--
-- TOC entry 3182 (class 2604 OID 16493)
-- Name: Tabletops id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Tabletops" ALTER COLUMN "id" SET DEFAULT "nextval"('"public"."Tabletops_id_seq"'::"regclass");


--
-- TOC entry 3191 (class 2606 OID 16476)
-- Name: Dishes Dishes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Dishes"
    ADD CONSTRAINT "Dishes_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3185 (class 2606 OID 16446)
-- Name: Ingredients Ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Ingredients"
    ADD CONSTRAINT "Ingredients_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3201 (class 2606 OID 16519)
-- Name: MenuDishes MenuDishes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."MenuDishes"
    ADD CONSTRAINT "MenuDishes_pkey" PRIMARY KEY ("menuId", "dishId");


--
-- TOC entry 3187 (class 2606 OID 16457)
-- Name: Menus Menus_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Menus"
    ADD CONSTRAINT "Menus_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3205 (class 2606 OID 16535)
-- Name: OrderDishes OrderDishes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "OrderDishes_pkey" PRIMARY KEY ("orderId", "dishId", "menuId");


--
-- TOC entry 3197 (class 2606 OID 16503)
-- Name: Orders Orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders"
    ADD CONSTRAINT "Orders_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3199 (class 2606 OID 16511)
-- Name: RecipeIngredients RecipeIngredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "RecipeIngredients_pkey" PRIMARY KEY ("recipeId", "ingredientId");


--
-- TOC entry 3189 (class 2606 OID 16468)
-- Name: Recipes Recipes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes"
    ADD CONSTRAINT "Recipes_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3203 (class 2606 OID 16527)
-- Name: SupplierIngredients SupplierIngredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "SupplierIngredients_pkey" PRIMARY KEY ("supplierId", "ingredientId");


--
-- TOC entry 3193 (class 2606 OID 16487)
-- Name: Suppliers Suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Suppliers"
    ADD CONSTRAINT "Suppliers_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3195 (class 2606 OID 16495)
-- Name: Tabletops Tabletops_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Tabletops"
    ADD CONSTRAINT "Tabletops_pkey" PRIMARY KEY ("id");


--
-- TOC entry 3215 (class 2606 OID 16541)
-- Name: OrderDishes fkey_dishId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "fkey_dishId" FOREIGN KEY ("dishId") REFERENCES "public"."Dishes"("id");


--
-- TOC entry 3211 (class 2606 OID 16566)
-- Name: MenuDishes fkey_dishId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."MenuDishes"
    ADD CONSTRAINT "fkey_dishId" FOREIGN KEY ("dishId") REFERENCES "public"."Dishes"("id") NOT VALID;


--
-- TOC entry 3206 (class 2606 OID 16586)
-- Name: Recipes fkey_dishId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Recipes"
    ADD CONSTRAINT "fkey_dishId" FOREIGN KEY ("dishId") REFERENCES "public"."Dishes"("id") NOT VALID;


--
-- TOC entry 3213 (class 2606 OID 16556)
-- Name: SupplierIngredients fkey_ingredientId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "fkey_ingredientId" FOREIGN KEY ("ingredientId") REFERENCES "public"."Ingredients"("id") NOT VALID;


--
-- TOC entry 3209 (class 2606 OID 16576)
-- Name: RecipeIngredients fkey_ingredientId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "fkey_ingredientId" FOREIGN KEY ("ingredientId") REFERENCES "public"."Ingredients"("id") NOT VALID;


--
-- TOC entry 3216 (class 2606 OID 16546)
-- Name: OrderDishes fkey_menuId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "fkey_menuId" FOREIGN KEY ("menuId") REFERENCES "public"."Menus"("id");


--
-- TOC entry 3210 (class 2606 OID 16561)
-- Name: MenuDishes fkey_menuId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."MenuDishes"
    ADD CONSTRAINT "fkey_menuId" FOREIGN KEY ("menuId") REFERENCES "public"."Menus"("id") NOT VALID;


--
-- TOC entry 3214 (class 2606 OID 16536)
-- Name: OrderDishes fkey_orderId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."OrderDishes"
    ADD CONSTRAINT "fkey_orderId" FOREIGN KEY ("orderId") REFERENCES "public"."Orders"("id");


--
-- TOC entry 3208 (class 2606 OID 16571)
-- Name: RecipeIngredients fkey_recipeId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."RecipeIngredients"
    ADD CONSTRAINT "fkey_recipeId" FOREIGN KEY ("recipeId") REFERENCES "public"."Recipes"("id") NOT VALID;


--
-- TOC entry 3212 (class 2606 OID 16551)
-- Name: SupplierIngredients fkey_supplierId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."SupplierIngredients"
    ADD CONSTRAINT "fkey_supplierId" FOREIGN KEY ("supplierId") REFERENCES "public"."Suppliers"("id") NOT VALID;


--
-- TOC entry 3207 (class 2606 OID 16581)
-- Name: Orders fkey_tabletopId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "public"."Orders"
    ADD CONSTRAINT "fkey_tabletopId" FOREIGN KEY ("tabletopId") REFERENCES "public"."Tabletops"("id") NOT VALID;


-- Completed on 2021-02-05 11:34:56 EST

--
-- PostgreSQL database dump complete
--

